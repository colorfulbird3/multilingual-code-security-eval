#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_WORDS 1000
#define MAX_WORD_LEN 100

// Structure para sa node ng binary search tree
typedef struct Node {
    char word[MAX_WORD_LEN];
    int count;
    struct Node *left, *right;
} Node;

// Function para gumawa ng bagong node
Node* createNode(char *word) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    strcpy(newNode->word, word);
    newNode->count = 1;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Function para mag-insert ng word sa BST
Node* insert(Node *root, char *word) {
    if (root == NULL) {
        return createNode(word);
    }
    
    int cmp = strcmp(word, root->word);
    if (cmp < 0) {
        root->left = insert(root->left, word);
    } else if (cmp > 0) {
        root->right = insert(root->right, word);
    } else {
        root->count++;
    }
    
    return root;
}

// Function para maghanap ng word sa BST
Node* search(Node *root, char *word) {
    if (root == NULL || strcmp(root->word, word) == 0) {
        return root;
    }
    
    if (strcmp(word, root->word) < 0) {
        return search(root->left, word);
    }
    
    return search(root->right, word);
}

// Function para mag-print ng inorder traversal
void inorder(Node *root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%s: %d\n", root->word, root->count);
        inorder(root->right);
    }
}

// Function para magbasa ng file at mag-extract ng mga salita
void readFileAndExtractWords(const char *filename, Node **root) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        printf("Hindi mabuksan ang file: %s\n", filename);
        return;
    }
    
    char word[MAX_WORD_LEN];
    int charIndex = 0;
    int ch;
    
    while ((ch = fgetc(file)) != EOF) {
        if (isalpha(ch)) {
            word[charIndex++] = tolower(ch);
        } else {
            if (charIndex > 0) {
                word[charIndex] = '\0';
                *root = insert(*root, word);
                charIndex = 0;
            }
        }
    }
    
    // Para sa huling salita kung walang kasunod na non-alphabetic character
    if (charIndex > 0) {
        word[charIndex] = '\0';
        *root = insert(*root, word);
    }
    
    fclose(file);
}

// Function para mag-save ng BST sa file (inorder)
void saveToFile(Node *root, FILE *file) {
    if (root != NULL) {
        saveToFile(root->left, file);
        fprintf(file, "%s: %d\n", root->word, root->count);
        saveToFile(root->right, file);
    }
}

// Function para mag-free ng memory ng BST
void freeTree(Node *root) {
    if (root != NULL) {
        freeTree(root->left);
        freeTree(root->right);
        free(root);
    }
}

int main() {
    Node *root = NULL;
    char filename[100];
    char searchWord[MAX_WORD_LEN];
    int choice;
    
    printf("Word Frequency Counter gamit ang Binary Search Tree\n");
    printf("================================================\n\n");
    
    // Pagbasa ng file
    printf("Ilagay ang pangalan ng file: ");
    scanf("%s", filename);
    
    readFileAndExtractWords(filename, &root);
    
    if (root == NULL) {
        printf("Walang nakitang salita sa file.\n");
        return 0;
    }
    
    printf("\nMga salita at frequency:\n");
    inorder(root);
    
    // Menu para sa paghahanap at pag-save
    do {
        printf("\n\nMenu:\n");
        printf("1. Maghanap ng salita\n");
        printf("2. I-save sa file\n");
        printf("3. Lumabas\n");
        printf("Pumili: ");
        scanf("%d", &choice);
        
        switch(choice) {
            case 1:
                printf("Ilagay ang salitang hahanapin: ");
                scanf("%s", searchWord);
                
                // Convert to lowercase
                for (int i = 0; searchWord[i]; i++) {
                    searchWord[i] = tolower(searchWord[i]);
                }
                
                Node *result = search(root, searchWord);
                if (result != NULL) {
                    printf("Ang salitang '%s' ay lumitaw ng %d beses.\n", 
                           searchWord, result->count);
                } else {
                    printf("Ang salitang '%s' ay hindi natagpuan.\n", searchWord);
                }
                break;
                
            case 2: {
                char outputFilename[100];
                printf("Ilagay ang pangalan ng output file: ");
                scanf("%s", outputFilename);
                
                FILE *outputFile = fopen(outputFilename, "w");
                if (outputFile == NULL) {
                    printf("Hindi mabuksan ang output file.\n");
                } else {
                    saveToFile(root, outputFile);
                    fclose(outputFile);
                    printf("Matagumpay na nai-save sa %s\n", outputFilename);
                }
                break;
            }
            
            case 3:
                printf("Paalam!\n");
                break;
                
            default:
                printf("Hindi valid na pagpipilian.\n");
        }
    } while (choice != 3);
    
    // Pag-free ng memory
    freeTree(root);
    
    return 0;
}