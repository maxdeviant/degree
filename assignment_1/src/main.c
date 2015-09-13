#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#include "fibonacci.h"

int main(int argc, char const *argv[]) {
    int n = atoi(argv[1]);

    printf("%" PRIu64 "\n", fibonacci(n));

    return 0;
}
