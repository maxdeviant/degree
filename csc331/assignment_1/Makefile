CFLAGS=-Werror -Wall -g3
INCLUDES=-I./include/
NAME=assignment_1


all: bin $(NAME)

clean:
	rm -f *.o
	rm -f $(NAME)

%.o: ./src/%.c
	$(CC) $(CFLAGS) $(LIB_INCLUDES) $(INCLUDES) -c $<

bin: $(NAME)
$(NAME): main.o fibonacci.o error.o
	$(CC) $(CLAGS) $(LIB_INCLUDES) $(INCLUDES) -o $(NAME) $^ -lm $(LIBS)

dist:
	tar -cjvf bowers_assignment1.tar.bz2 Makefile src/* include/*
