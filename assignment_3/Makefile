CFLAGS=-Werror -Wall -g3
INCLUDES=-I./include/
NAME=assignment_3


all: bin $(NAME)

clean:
	rm -f *.o
	rm -f $(NAME)

%.o: ./src/%.c
	$(CC) $(CFLAGS) $(LIB_INCLUDES) $(INCLUDES) -c $<

bin: $(NAME)
$(NAME): main.o buffer.o error.o
	$(CC) $(CLAGS) $(LIB_INCLUDES) $(INCLUDES) -o $(NAME) $^ -lm $(LIBS)

dist:
	tar -cvf bowers_assignment3.tar Makefile src/* include/*