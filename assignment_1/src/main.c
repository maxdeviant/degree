/**
 * Marshall Bowesr
 * Dr. Bin Lu
 * CSC331-80
 * 21 September 2015
 * main.c
 */

#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#include "fibonacci.h"

int main(int argc, char const *argv[]) {
    if (argc < 2) {
        printf("%s\n", "ERROR: No input provided.");

        return 0;
    }

    int n = atoi(argv[1]);

    if (n < 0) {
        printf("%s\n", "ERROR: n cannot be negative.");

        return 0;
    }

    if (n > 93) {
        printf("%s\n", "ERROR: n too large.");

        return 0;
    }

    pid_t pid;

    pid = fork();

    if (pid < 0) {
        printf("%s\n", "ERROR: An error occurred while forking the child process.");

        return 0;
    }

    if (pid == 0) {
        printf("%" PRIu64 "\n", fibonacci(n));
    } else {
        wait(NULL);
    }

    return 0;
}
