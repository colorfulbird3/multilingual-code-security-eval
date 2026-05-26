```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_LINE_LENGTH 1024
#define MAX_FILENAME_LENGTH 256

void trim_whitespace(char *str) {
    char *end;
    while (isspace((unsigned char)*str)) str++;
    if (*str == 0) return;
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;
    *(end + 1) = '\0';
}

int is_code_block_start(const char *line) {
    const char *trimmed = line;
    while (isspace((unsigned char)*trimmed)) trimmed++;
    return (strncmp(trimmed, "```", 3) == 0);
}

int is_code_block_end(const char *line) {
    return is_code_block_start(line);
}

void extract_code_blocks(const char *input_filename, const char *output_filename) {
    FILE *infile = fopen(input_filename, "r");
    if (!infile) {
        fprintf(stderr, "Error: Cannot open input file '%s'\n", input_filename);
        exit(1);
    }

    FILE *outfile = fopen(output_filename, "w");
    if (!outfile) {
        fprintf(stderr, "Error: Cannot open output file '%s'\n", output_filename);
        fclose(infile);
        exit(1);
    }

    char line[MAX_LINE_LENGTH];
    int in_code_block = 0;
    int code_block_count = 0;
    int longest_block_length = 0;
    char *longest_block = NULL;
    char current_block[MAX_LINE_LENGTH * 100]; // assume max 100 lines per block
    int current_length = 0;

    while (fgets(line, sizeof(line), infile)) {
        trim_whitespace(line);
        if (is_code_block_start(line)) {
            if (in_code_block) {
                // nested code block, ignore
                continue;
            }
            in_code_block = 1;
            current_length = 0;
            current_block[0] = '\0';
            continue;
        }
        if (in_code_block && is_code_block_end(line)) {
            in_code_block = 0;
            code_block_count++;
            if (current_length > longest_block_length) {
                longest_block_length = current_length;
                free(longest_block);
                longest_block = strdup(current_block);
            }
            continue;
        }
        if (in_code_block) {
            int len = strlen(line);
            if (current_length + len < sizeof(current_block)) {
                strcat(current_block, line);
                current_length += len;
            }
        }
    }

    if (longest_block) {
        fprintf(outfile, "%s", longest_block);
        free(longest_block);
    }

    fclose(infile);
    fclose(outfile);
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <input_file> <output_file>\n", argv[0]);
        return 1;
    }

    extract_code_blocks(argv[1], argv[2]);
    printf("Code extraction complete. Output written to '%s'\n", argv[2]);
    return 0;
}
```