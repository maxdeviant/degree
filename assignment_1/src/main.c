/**
 * Marshall Bowers
 * Dr. Bin Lu
 * CSC331-80
 * 21 September 2015
 * main.c
 */

#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#include "error.h"
#include "fibonacci.h"

int main(int argc, const char *argv[]) {
    if (argc < 2) {
        error_and_die("No input provided.");
    }

    int n = atoi(argv[1]);

    if (n < 0) {
        error_and_die("Input cannot be negative.");
    }

    if (n > 93) {
        error_and_die("Input too large.");
    }

    pid_t pid;

    pid = fork();

    if (pid < 0) {
        error_and_die("An unhandled error occurred while forking the child process.");
    }

    if (pid == 0) {
        printf("%" PRIu64 "\n", fibonacci(n));
    } else {
        wait(NULL);
    }

    return 0;
}
