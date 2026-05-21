#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_ATTEMPTS 6
#define WORD_LENGTH 5

// List of possible words (you can expand this)
const char *word_list[] = {
    "apple", "beach", "crane", "dance", "eagle",
    "flame", "grape", "house", "igloo", "joker",
    "knife", "lemon", "mango", "noble", "ocean",
    "piano", "queen", "river", "snake", "tiger",
    "umbra", "vivid", "whale", "xenon", "yacht",
    "zebra"
};

int word_count = sizeof(word_list) / sizeof(word_list[0]);

void to_upper(char *str) {
    for (int i = 0; str[i]; i++) {
        if (str[i] >= 'a' && str[i] <= 'z')
            str[i] -= 32;
    }
}

int is_valid_word(const char *word) {
    if (strlen(word) != WORD_LENGTH) return 0;
    for (int i = 0; word[i]; i++) {
        if (!((word[i] >= 'a' && word[i] <= 'z') || (word[i] >= 'A' && word[i] <= 'Z')))
            return 0;
    }
    return 1;
}

void evaluate_guess(const char *secret, const char *guess, char *result) {
    int secret_count[26] = {0};
    int guess_count[26] = {0};
    int i;

    // First pass: mark exact matches (green)
    for (i = 0; i < WORD_LENGTH; i++) {
        if (guess[i] == secret[i]) {
            result[i] = 'G'; // Green
        } else {
            result[i] = ' '; // Placeholder
            secret_count[secret[i] - 'A']++;
            guess_count[guess[i] - 'A']++;
        }
    }

    // Second pass: mark present but wrong position (yellow)
    for (i = 0; i < WORD_LENGTH; i++) {
        if (result[i] == ' ') {
            int idx = guess[i] - 'A';
            if (guess_count[idx] > 0 && secret_count[idx] > 0) {
                result[i] = 'Y'; // Yellow
                guess_count[idx]--;
                secret_count[idx]--;
            } else {
                result[i] = 'X'; // Gray
            }
        }
    }
    result[WORD_LENGTH] = '\0';
}

int main() {
    char secret[WORD_LENGTH + 1];
    char guess[WORD_LENGTH + 1];
    char result[WORD_LENGTH + 1];
    int attempts = 0;
    int won = 0;

    srand(time(NULL));
    strcpy(secret, word_list[rand() % word_count]);
    to_upper(secret);

    printf("Welcome to Wordle!\n");
    printf("Guess the 5-letter word. You have %d attempts.\n", MAX_ATTEMPTS);

    while (attempts < MAX_ATTEMPTS && !won) {
        printf("\nAttempt %d/%d: ", attempts + 1, MAX_ATTEMPTS);
        if (fgets(guess, sizeof(guess), stdin) == NULL) {
            printf("Error reading input.\n");
            continue;
        }
        // Remove newline
        size_t len = strlen(guess);
        if (len > 0 && guess[len - 1] == '\n')
            guess[len - 1] = '\0';

        if (!is_valid_word(guess)) {
            printf("Invalid input. Please enter a 5-letter word.\n");
            continue;
        }

        to_upper(guess);

        evaluate_guess(secret, guess, result);

        // Display result
        printf("Result: ");
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (result[i] == 'G')
                printf("\033[0;32m%c\033[0m", guess[i]); // Green
            else if (result[i] == 'Y')
                printf("\033[0;33m%c\033[0m", guess[i]); // Yellow
            else
                printf("\033[0;37m%c\033[0m", guess[i]); // Gray/White
        }
        printf("\n");

        if (strcmp(secret, guess) == 0) {
            won = 1;
            printf("\nCongratulations! You guessed the word: %s\n", secret);
        }

        attempts++;
    }

    if (!won) {
        printf("\nSorry, you've used all attempts. The word was: %s\n", secret);
    }

    return 0;
}