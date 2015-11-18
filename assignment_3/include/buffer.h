/**
 * Marshall Bowers
 * Dr. Bin Lu
 * CSC331-80
 * 18 November 2015
 * buffer.h
 */

#pragma once
#define BUFFER_SIZE 5

typedef int buffer_item;

void *producer(void *param);
void *consumer(void *param);

int insert_item(buffer_item item);
int remove_item(buffer_item *item);
