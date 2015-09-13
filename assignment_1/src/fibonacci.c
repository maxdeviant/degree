#include "fibonacci.h"

uint64_t fibonacci_aux(int n, uint64_t a, uint64_t b);

uint64_t fibonacci(int n) {
    return fibonacci_aux(n, 0, 1);
}

uint64_t fibonacci_aux(int n, uint64_t a, uint64_t b) {
    if (n > 0) {
        return fibonacci_aux(n - 1, b, a + b);
    }

    return a;
}
