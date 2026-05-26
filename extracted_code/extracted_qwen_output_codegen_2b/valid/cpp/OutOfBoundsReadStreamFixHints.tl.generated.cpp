#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>

// ============================================================
// Constants
// ============================================================
#define MAX_NAME_LEN 64
#define MAX_ITEMS 100
#define MAX_TRANSACTIONS 1000
#define MAX_ITEMSET_SIZE 10
#define MIN_SUPPORT 2
#define MIN_CONFIDENCE 0.5

// ============================================================
// Data Structures
// ============================================================
typedef struct {
    char name[MAX_NAME_LEN];
    int count;
} Item;

typedef struct {
    int items[MAX_ITEMSET_SIZE];
    int size;
    int count;
} Itemset;

typedef struct {
    int items[MAX_ITEMSET_SIZE];
    int size;
    double confidence;
    double support;
} Rule;

// ============================================================
// Global Variables
// ============================================================
Item item_list[MAX_ITEMS];
int item_count = 0;
int transactions[MAX_TRANSACTIONS][MAX_ITEMSET_SIZE];
int transaction_sizes[MAX_TRANSACTIONS];
int transaction_count = 0;
Itemset frequent_itemsets[MAX_ITEMS];
int frequent_count = 0;
Rule rules[MAX_ITEMS * MAX_ITEMS];
int rule_count = 0;

// ============================================================
// Function Prototypes
// ============================================================
void load_data(const char* filename);
int get_item_index(const char* name);
void add_item(const char* name);
void find_frequent_itemsets(void);
void generate_rules(void);
void print_results(void);
bool is_subset(int* set1, int size1, int* set2, int size2);
int count_support(int* items, int size);
void generate_candidates(Itemset* candidates, int* candidate_count, Itemset* prev, int prev_count);
bool has_infrequent_subset(Itemset* candidate, Itemset* prev, int prev_count);

// ============================================================
// Main Function
// ============================================================
int main(int argc, char* argv[]) {
    if (argc < 2) {
        printf("Usage: %s <datafile>\n", argv[0]);
        return 1;
    }
    
    load_data(argv[1]);
    find_frequent_itemsets();
    generate_rules();
    print_results();
    
    return 0;
}

// ============================================================
// Data Loading
// ============================================================
void load_data(const char* filename) {
    FILE* file = fopen(filename, "r");
    if (!file) {
        printf("Error: Cannot open file %s\n", filename);
        exit(1);
    }
    
    char line[1024];
    while (fgets(line, sizeof(line), file) && transaction_count < MAX_TRANSACTIONS) {
        // Remove newline
        size_t len = strlen(line);
        if (len > 0 && line[len-1] == '\n') line[len-1] = '\0';
        
        // Parse items separated by commas
        char* token = strtok(line, ",");
        int item_idx = 0;
        
        while (token && item_idx < MAX_ITEMSET_SIZE) {
            // Trim whitespace
            while (*token == ' ') token++;
            char* end = token + strlen(token) - 1;
            while (end > token && *end == ' ') end--;
            *(end+1) = '\0';
            
            int idx = get_item_index(token);
            transactions[transaction_count][item_idx] = idx;
            item_idx++;
            token = strtok(NULL, ",");
        }
        
        transaction_sizes[transaction_count] = item_idx;
        transaction_count++;
    }
    
    fclose(file);
    printf("Loaded %d transactions with %d unique items\n", transaction_count, item_count);
}

int get_item_index(const char* name) {
    for (int i = 0; i < item_count; i++) {
        if (strcmp(item_list[i].name, name) == 0) {
            return i;
        }
    }
    add_item(name);
    return item_count - 1;
}

void add_item(const char* name) {
    if (item_count >= MAX_ITEMS) {
        printf("Error: Too many items\n");
        exit(1);
    }
    strncpy(item_list[item_count].name, name, MAX_NAME_LEN - 1);
    item_list[item_count].name[MAX_NAME_LEN - 1] = '\0';
    item_list[item_count].count = 0;
    item_count++;
}

// ============================================================
// Apriori Algorithm
// ============================================================
void find_frequent_itemsets(void) {
    // Count individual item support
    for (int i = 0; i < item_count; i++) {
        int items[1] = {i};
        item_list[i].count = count_support(items, 1);
    }
    
    // Generate frequent 1-itemsets
    Itemset current[MAX_ITEMS];
    int current_count = 0;
    
    for (int i = 0; i < item_count; i++) {
        if (item_list[i].count >= MIN_SUPPORT) {
            current[current_count].items[0] = i;
            current[current_count].size = 1;
            current[current_count].count = item_list[i].count;
            current_count++;
        }
    }
    
    // Copy to global frequent itemsets
    for (int i = 0; i < current_count; i++) {
        frequent_itemsets[frequent_count++] = current[i];
    }
    
    // Generate larger itemsets
    int k = 2;
    while (current_count > 0 && k <= MAX_ITEMSET_SIZE) {
        Itemset candidates[MAX_ITEMS];
        int candidate_count = 0;
        
        generate_candidates(candidates, &candidate_count, current, current_count);
        
        // Count support for candidates
        Itemset next[MAX_ITEMS];
        int next_count = 0;
        
        for (int i = 0; i < candidate_count; i++) {
            candidates[i].count = count_support(candidates[i].items, candidates[i].size);
            if (candidates[i].count >= MIN_SUPPORT) {
                next[next_count++] = candidates[i];
            }
        }
        
        // Copy to global frequent itemsets
        for (int i = 0; i < next_count; i++) {
            frequent_itemsets[frequent_count++] = next[i];
        }
        
        // Prepare for next iteration
        for (int i = 0; i < next_count; i++) {
            current[i] = next[i];
        }
        current_count = next_count;
        k++;
    }
}

void generate_candidates(Itemset* candidates, int* candidate_count, Itemset* prev, int prev_count) {
    for (int i = 0; i < prev_count; i++) {
        for (int j = i + 1; j < prev_count; j++) {
            // Check if first k-2 items are equal
            bool joinable = true;
            for (int m = 0; m < prev[i].size - 1; m++) {
                if (prev[i].items[m] != prev[j].items[m]) {
                    joinable = false;
                    break;
                }
            }
            
            if (joinable) {
                // Create new candidate
                Itemset candidate;
                candidate.size = prev[i].size + 1;
                
                // Copy first k-1 items
                for (int m = 0; m < prev[i].size; m++) {
                    candidate.items[m] = prev[i].items[m];
                }
                candidate.items[prev[i].size] = prev[j].items[prev[j].size - 1];
                
                // Check if all subsets are frequent
                if (!has_infrequent_subset(&candidate, prev, prev_count)) {
                    candidates[*candidate_count] = candidate;
                    (*candidate_count)++;
                }
            }
        }
    }
}

bool has_infrequent_subset(Itemset* candidate, Itemset* prev, int prev_count) {
    // Generate all subsets of size k-1 and check if they are in prev
    int subset[MAX_ITEMSET_SIZE];
    
    for (int i = 0; i < candidate->size; i++) {
        int subset_idx = 0;
        for (int j = 0; j < candidate->size; j++) {
            if (j != i) {
                subset[subset_idx++] = candidate->items[j];
            }
        }
        
        // Check if this subset exists in prev
        bool found = false;
        for (int k = 0; k < prev_count; k++) {
            if (prev[k].size == candidate->size - 1) {
                bool match = true;
                for (int m = 0; m < prev[k].size; m++) {
                    if (prev[k].items[m] != subset[m]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    found = true;
                    break;
                }
            }
        }
        
        if (!found) {
            return true; // Has infrequent subset
        }
    }
    
    return false;
}

int count_support(int* items, int size) {
    int count = 0;
    for (int t = 0; t < transaction_count; t++) {
        if (is_subset(items, size, transactions[t], transaction_sizes[t])) {
            count++;
        }
    }
    return count;
}

bool is_subset(int* set1, int size1, int* set2, int size2) {
    for (int i = 0; i < size1; i++) {
        bool found = false;
        for (int j = 0; j < size2; j++) {
            if (set1[i] == set2[j]) {
                found = true;
                break;
            }
        }
        if (!found) return false;
    }
    return true;
}

// ============================================================
// Rule Generation
// ============================================================
void generate_rules(void) {
    for (int i = 0; i < frequent_count; i++) {
        Itemset* itemset = &frequent_itemsets[i];
        if (itemset->size < 2) continue;
        
        // Generate all non-empty proper subsets
        int total_subsets = 1 << itemset->size;
        
        for (int mask = 1; mask < total_subsets - 1; mask++) {
            int antecedent[MAX_ITEMSET_SIZE];
            int consequent[MAX_ITEMSET_SIZE];
            int ant_size = 0, cons_size = 0;
            
            for (int j = 0; j < itemset->size; j++) {
                if (mask & (1 << j)) {
                    antecedent[ant_size++] = itemset->items[j];
                } else {
                    consequent[cons_size++] = itemset->items[j];
                }
            }
            
            // Calculate confidence
            int ant_support = count_support(antecedent, ant_size);
            double confidence = (double)itemset->count / ant_support;
            
            if (confidence >= MIN_CONFIDENCE) {
                Rule rule;
                for (int j = 0; j < ant_size; j++) {
                    rule.items[j] = antecedent[j];
                }
                for (int j = 0; j < cons_size; j++) {
                    rule.items[ant_size + j] = consequent[j];
                }
                rule.size = ant_size + cons_size;
                rule.confidence = confidence;
                rule.support = (double)itemset->count / transaction_count;
                rules[rule_count++] = rule;
            }
        }
    }
}

// ============================================================
// Output
// ============================================================
void print_results(void) {
    printf("\n=== Frequent Itemsets ===\n");
    for (int i = 0; i < frequent_count; i++) {
        printf("{");
        for (int j = 0; j < frequent_itemsets[i].size; j++) {
            if (j > 0) printf(", ");
            printf("%s", item_list[frequent_itemsets[i].items[j]].name);
        }
        printf("} (support: %d)\n", frequent_itemsets[i].count);
    }
    
    printf("\n=== Association Rules ===\n");
    for (int i = 0; i < rule_count; i++) {
        printf("{");
        int ant_size = rules[i].size / 2;
        for (int j = 0; j < ant_size; j++) {
            if (j > 0) printf(", ");
            printf("%s", item_list[rules[i].items[j]].name);
        }
        printf("} -> {");
        for (int j = ant_size; j < rules[i].size; j++) {
            if (j > ant_size) printf(", ");
            printf("%s", item_list[rules[i].items[j]].name);
        }
        printf("} (confidence: %.2f, support: %.2f)\n", 
               rules[i].confidence, rules[i].support);
    }
}