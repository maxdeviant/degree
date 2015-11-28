	.text
	.globl main
main:
	#begin prologue -- main
	subu $sp, $sp, 24    # stack frame is at least 24 bytes
	sw $fp, 4($sp)       # save caller's frame pointer
	sw $ra, 0($sp)       # save return address
	addi $fp, $sp, 20    # set up main's frame pointer
	#end prologue -- main
	#caller Test.main preparing for function call
	sw $ra, -20($fp)       # save return address
	li $a0, 1     # new object has 1 fields
	mul $a0, $a0, 4        # each field is given 4 bytes
	li $v0, 9              # load 9 into $v0 for syscall
	syscall                # allocates $a0 amount of memory, returns ptr via $v0
	move $a0, $v0            # store arg0 ("this") in reg $a0
	sw $v0, -16($sp)          # also store arg0 - address of this - in stack
	jal Tester.foo           # method call -- jump to Tester.foo
	#execution back in caller Test.main
	lw $ra, -20($fp)       # restore return address
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	#begin epilogue -- main
	lw $ra, 0($sp)       # restore return address
	lw $fp, 4($sp)       # restore caller's frame pointer
	addi $sp, $sp, 24    # pop the stack
	#end epilogue -- main
	li $v0, 10
	syscall
Tester.foo:
	#begin prologue -- Tester.foo
	subu $sp, $sp, 28   # stack frame push 28 bytes onto stack
	sw $fp, 8($sp)       # save frame pointer
	sw $ra, 4($sp)       # save return address
	addi $fp, $sp, 24       # set up frame pointer
	#end prologue -- Tester.foo
	li $v0, 1        # load literal 1 into $v0
	mul $v0, $v0, 4        # each ary value is given 4 bytes
	add $v0, $v0, 4        # an additional leading word for the .length field
	move $a0, $v0          # copy a0 <- v0
	li $v0, 9              # load 9 into $v0 for syscall
	syscall                # allocates $a0 amount of memory, returns ptr in $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # push v0 onto stack
	add $v0, $fp, -24      # load addr of local variable array into $v0
	lw $v1, 0($sp)         # pop stack value into $v1
	addi $sp, $sp, 4       # ...stack pop
	sw $v1, 0($v0)         # assign value in $v1 into addr in $v0
	add $v0, $fp, -24      # load addr of local variable array into $v0
	lw $v0, 0($v0)         # load address of array into $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # store address of array in stack
	li $v0, 0        # load literal 0 into $v0
	mul $v0, $v0, 4        # 4 bytes for each entry in array
	add $v0, $v0, 4        # first word of array is .length field
	lw $v1, 0($sp)         # load address of array into $v1
	add $sp, $sp, 4        # ...pop stack
	add $v0, $v1, $v0      # add array address and offset, store in $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # store address of array index in stack
	li $v0, 1        # load literal 1 into $v0
	lw $v1, 0($sp)         # load address of array index into $v1
	add $sp, $sp, 4        # ...pop stack
	sw $v0, 0($v1)         # save value in $v0 into array index location in $v1
	lw $v0, -24($fp)      # load offset of local variable syntaxtree.IdentifierExp@2cd828d5 into $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # store address of array in stack
	li $v0, 0        # load literal 0 into $v0
	mul $v0, $v0, 4        # 4 bytes for each entry in array
	add $v0, $v0, 4        # first word of array is .length field
	lw $v1, 0($sp)         # load address of array into $v1
	add $sp, $sp, 4        # ...pop stack
	add $v0, $v1, $v0      # add array address and offset, store in $v0
	lw $v0, 0($v0)         # return value of array index in $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	li $v0, 0        # load literal 0 into $v0
	#begin epilogue -- Tester.foo
	lw $ra, -20($fp)     # restore return address
	lw $fp, -16($fp)     # restore frame pointer
	addi $sp, $sp, 28       # pop the stack
	#end epilogue -- Tester.foo
	jr $ra
	
	.data


