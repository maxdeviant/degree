	.text
	.globl main
main:
	#begin prologue -- main
	subu $sp, $sp, 24    # stack frame is at least 24 bytes
	sw $fp, 4($sp)       # save caller's frame pointer
	sw $ra, 0($sp)       # save return address
	addi $fp, $sp, 20    # set up main's frame pointer
	#end prologue -- main
	li $v0, 42        # load literal 42 into $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # push v0 onto stack
	li $v0, 37        # load literal 37 into $v0
	lw $v1, 0($sp)         # pop stack value into $v1
	addi $sp, $sp, 4       # ...stack pop
	slt $v0, $v1, $v0      # if $v1 < $v0 ? $v0 = 1 : $v0 = 0
	beqz $v0, False11              # if expr == false, jump to False11
	li $v0, 0        # load literal 0 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	j DoneIf11               # jump past false
False11:
	li $v0, 42        # load literal 42 into $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # push v0 onto stack
	li $v0, 42        # load literal 42 into $v0
	lw $v1, 0($sp)         # pop stack value into $v1
	addi $sp, $sp, 4       # ...stack pop
	slt $v0, $v1, $v0      # if $v1 < $v0 ? $v0 = 1 : $v0 = 0
	beqz $v0, False12              # if expr == false, jump to False12
	li $v0, 1        # load literal 1 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	j DoneIf12               # jump past false
False12:
	li $v0, 37        # load literal 37 into $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # push v0 onto stack
	li $v0, 42        # load literal 42 into $v0
	lw $v1, 0($sp)         # pop stack value into $v1
	addi $sp, $sp, 4       # ...stack pop
	slt $v0, $v1, $v0      # if $v1 < $v0 ? $v0 = 1 : $v0 = 0
	beqz $v0, False13              # if expr == false, jump to False13
	li $v0, 2        # load literal 2 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	j DoneIf13               # jump past false
False13:
	li $v0, 3        # load literal 3 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
DoneIf13:
DoneIf12:
DoneIf11:
	#begin epilogue -- main
	lw $ra, 0($sp)       # restore return address
	lw $fp, 4($sp)       # restore caller's frame pointer
	addi $sp, $sp, 24    # pop the stack
	#end epilogue -- main
	li $v0, 10
	syscall
	
	.data


