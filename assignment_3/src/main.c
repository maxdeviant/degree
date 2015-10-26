/**
 * Marshall Bowers
 * Dr. Bin Lu
 * CSC331-80
 * 16 November 2015
 * main.c
 */

#include <stdlib.h>
#include <stdio.h>

#include "error.h"

int main(int argc, const char *argv[]) {
    if (argc < 3) {
        error_and_die("Missing required input.");
    }

    int sleep_duration = atoi(argv[1]);

    int producer_count = atoi(argv[2]);

    int consumer_count = atoi(argv[3]);

    return 0;
}
