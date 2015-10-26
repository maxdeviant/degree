#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

#include "error.h"
#include "buffer.h"

void *producer(void *param) {
    buffer_item random;
    int r;

    while (1) {
        r = rand() % 5;

        sleep(r);

        random = rand();

        if (insert_item(random)) {
            error_and_die("An error occurred while producing.");
        }

        printf("Producer produced %d\n", random);
    }
}

void *consumer(void *param) {
    buffer_item random;
    int r;

    while (1) {
        r = rand() % 5;

        sleep(r);

        if (remove_item(&random)) {
            error_and_die("An error occurred while consuming.");
        }

        printf("Consumer consumed %d\n", random);
    }
}

int insert_item(buffer_item item) {
    return 0;
}

int remove_item(buffer_item *item) {
    return 0;
}
