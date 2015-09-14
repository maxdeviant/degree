/**
 * Marshall Bowesr
 * Dr. Bin Lu
 * CSC331-80
 * 21 September 2015
 * error.c
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "error.h"

void error_and_die(const char *message) {
    const size_t buffer_size = strlen("ERROR: ") + strlen(message) + strlen("\n\0");

    char buffer[buffer_size];

    memset(buffer, '\0', buffer_size);

    sprintf(buffer, "%c[%dm%s%c[%dm", 0x1B, 31, "ERROR", 0x1B, 0x0);
    sprintf(buffer + strlen(buffer), ": %s\n", message);
    printf("%s", buffer);

    exit(0);
}
