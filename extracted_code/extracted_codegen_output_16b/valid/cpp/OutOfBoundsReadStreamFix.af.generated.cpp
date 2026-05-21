#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_LINE_LENGTH 1024
#define MAX_TABLE_ROWS 1000
#define MAX_TABLE_COLS 50

typedef struct {
    char *cells[MAX_TABLE_COLS];
    int num_cells;
} TableRow;

typedef struct {
    TableRow rows[MAX_TABLE_ROWS];
    int num_rows;
    int num_cols;
} Table;

void trim_whitespace(char *str) {
    char *end;
    while (isspace((unsigned char)*str)) str++;
    if (*str == 0) return;
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;
    *(end + 1) = '\0';
}

char* extract_cell_content(const char *line, int *pos) {
    char cell[MAX_LINE_LENGTH];
    int cell_pos = 0;
    int in_pipe = 0;
    
    while (line[*pos] != '\0' && line[*pos] != '|') {
        if (line[*pos] == '\\' && line[*pos + 1] == '|') {
            cell[cell_pos++] = '|';
            (*pos) += 2;
        } else {
            cell[cell_pos++] = line[*pos];
            (*pos)++;
        }
    }
    cell[cell_pos] = '\0';
    trim_whitespace(cell);
    return strdup(cell);
}

int parse_table_line(const char *line, TableRow *row) {
    int pos = 0;
    int len = strlen(line);
    
    row->num_cells = 0;
    
    if (len == 0) return 0;
    
    if (line[0] == '|') {
        pos = 1;
    }
    
    while (pos < len && row->num_cells < MAX_TABLE_COLS) {
        if (line[pos] == '|') {
            row->cells[row->num_cells] = strdup("");
            row->num_cells++;
            pos++;
            continue;
        }
        
        row->cells[row->num_cells] = extract_cell_content(line, &pos);
        row->num_cells++;
        
        if (line[pos] == '|') {
            pos++;
        }
    }
    
    return row->num_cells;
}

int is_separator_line(const char *line) {
    int i = 0;
    while (line[i] != '\0') {
        if (line[i] != '|' && line[i] != '-' && line[i] != ':' && line[i] != ' ' && line[i] != '\t' && line[i] != '\n' && line[i] != '\r') {
            return 0;
        }
        i++;
    }
    return 1;
}

int is_table_line(const char *line) {
    int i = 0;
    int has_pipe = 0;
    int has_content = 0;
    
    while (line[i] != '\0') {
        if (line[i] == '|') {
            has_pipe = 1;
        } else if (!isspace((unsigned char)line[i])) {
            has_content = 1;
        }
        i++;
    }
    
    return has_pipe && has_content;
}

void convert_table_to_html(FILE *output, Table *table) {
    fprintf(output, "<table>\n");
    
    for (int i = 0; i < table->num_rows; i++) {
        fprintf(output, "  <tr>\n");
        for (int j = 0; j < table->rows[i].num_cells; j++) {
            if (i == 0) {
                fprintf(output, "    <th>%s</th>\n", table->rows[i].cells[j] ? table->rows[i].cells[j] : "");
            } else {
                fprintf(output, "    <td>%s</td>\n", table->rows[i].cells[j] ? table->rows[i].cells[j] : "");
            }
        }
        fprintf(output, "  </tr>\n");
    }
    
    fprintf(output, "</table>\n");
}

void convert_markdown_to_html(FILE *input, FILE *output) {
    char line[MAX_LINE_LENGTH];
    Table current_table;
    int in_table = 0;
    int in_code_block = 0;
    int in_list = 0;
    int list_type = 0; // 0 = none, 1 = unordered, 2 = ordered
    
    fprintf(output, "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n<title>Converted Document</title>\n</head>\n<body>\n");
    
    while (fgets(line, sizeof(line), input)) {
        line[strcspn(line, "\n")] = '\0';
        line[strcspn(line, "\r")] = '\0';
        
        // Handle code blocks
        if (strncmp(line, "```", 3) == 0) {
            if (in_code_block) {
                fprintf(output, "</code></pre>\n");
                in_code_block = 0;
            } else {
                fprintf(output, "<pre><code>");
                in_code_block = 1;
            }
            continue;
        }
        
        if (in_code_block) {
            fprintf(output, "%s\n", line);
            continue;
        }
        
        // Handle tables
        if (is_table_line(line) && !is_separator_line(line)) {
            if (!in_table) {
                in_table = 1;
                current_table.num_rows = 0;
                current_table.num_cols = 0;
            }
            
            if (current_table.num_rows < MAX_TABLE_ROWS) {
                TableRow row;
                int num_cells = parse_table_line(line, &row);
                if (num_cells > 0) {
                    current_table.rows[current_table.num_rows] = row;
                    current_table.num_rows++;
                    if (num_cells > current_table.num_cols) {
                        current_table.num_cols = num_cells;
                    }
                }
            }
            continue;
        } else if (in_table) {
            convert_table_to_html(output, &current_table);
            in_table = 0;
        }
        
        // Handle headers
        if (line[0] == '#') {
            int level = 0;
            while (line[level] == '#') level++;
            if (level > 6) level = 6;
            
            char *content = line + level;
            while (*content == ' ') content++;
            
            fprintf(output, "<h%d>%s</h%d>\n", level, content, level);
            continue;
        }
        
        // Handle horizontal rules
        if (strncmp(line, "---", 3) == 0 || strncmp(line, "***", 3) == 0 || strncmp(line, "___", 3) == 0) {
            fprintf(output, "<hr>\n");
            continue;
        }
        
        // Handle lists
        if (strncmp(line, "- ", 2) == 0 || strncmp(line, "* ", 2) == 0) {
            if (!in_list || list_type != 1) {
                if (in_list) fprintf(output, "</ul>\n");
                fprintf(output, "<ul>\n");
                in_list = 1;
                list_type = 1;
            }
            fprintf(output, "<li>%s</li>\n", line + 2);
            continue;
        }
        
        if (isdigit((unsigned char)line[0]) && strstr(line, ". ") != NULL) {
            if (!in_list || list_type != 2) {
                if (in_list) fprintf(output, "</ul>\n");
                fprintf(output, "<ol>\n");
                in_list = 1;
                list_type = 2;
            }
            char *content = strstr(line, ". ") + 2;
            fprintf(output, "<li>%s</li>\n", content);
            continue;
        }
        
        // Close list if we're not in a list item
        if (in_list && line[0] != '-' && line[0] != '*' && !isdigit((unsigned char)line[0])) {
            if (list_type == 1) fprintf(output, "</ul>\n");
            else fprintf(output, "</ol>\n");
            in_list = 0;
            list_type = 0;
        }
        
        // Handle paragraphs and inline formatting
        if (strlen(line) > 0) {
            fprintf(output, "<p>%s</p>\n", line);
        } else {
            fprintf(output, "\n");
        }
    }
    
    // Close any open tags
    if (in_table) {
        convert_table_to_html(output, &current_table);
    }
    
    if (in_code_block) {
        fprintf(output, "</code></pre>\n");
    }
    
    if (in_list) {
        if (list_type == 1) fprintf(output, "</ul>\n");
        else fprintf(output, "</ol>\n");
    }
    
    fprintf(output, "</body>\n</html>\n");
}

int main(int argc, char *argv[]) {
    FILE *input, *output;
    
    if (argc < 3) {
        fprintf(stderr, "Usage: %s <input.md> <output.html>\n", argv[0]);
        return 1;
    }
    
    input = fopen(argv[1], "r");
    if (!input) {
        fprintf(stderr, "Error: Cannot open input file %s\n", argv[1]);
        return 1;
    }
    
    output = fopen(argv[2], "w");
    if (!output) {
        fprintf(stderr, "Error: Cannot open output file %s\n", argv[2]);
        fclose(input);
        return 1;
    }
    
    convert_markdown_to_html(input, output);
    
    fclose(input);
    fclose(output);
    
    printf("Conversion complete: %s -> %s\n", argv[1], argv[2]);
    return 0;
}