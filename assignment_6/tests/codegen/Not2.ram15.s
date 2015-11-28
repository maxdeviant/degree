	.text
	.globl main
main:
	#begin prologue -- main
	subu $sp, $sp, 24    # stack frame is at least 24 bytes
	sw $fp, 4($sp)       # save caller's frame pointer
	sw $ra, 0($sp)       # save return address
	addi $fp, $sp, 20    # set up main's frame pointer
	#end prologue -- main
	li $v0, 1              # load int_literal 1 into $v0 to represent true
	beqz $v0, False16              # if expr == false, jump to False16
	li $v0, 0        # load literal 0 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	j DoneIf16               # jump past false
False16:
	li $v0, 0              # load int_literal 0 into $v0 to represent false
	beqz $v0, False17              # if expr == false, jump to False17
	li $v0, 1        # load literal 1 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	j DoneIf17               # jump past false
False17:
	li $v0, 2        # load literal 2 into $v0
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
DoneIf17:
DoneIf16:
	#begin epilogue -- main
	lw $ra, 0($sp)       # restore return address
	lw $fp, 4($sp)       # restore caller's frame pointer
	addi $sp, $sp, 24    # pop the stack
	#end epilogue -- main
	li $v0, 10
	syscall
	
	.data


