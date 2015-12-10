	.text
	.globl main
main:
	# begin prologue -- main
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set main's frame pointer
	# end prologue -- main
	# begin print
	# begin minus
	# begin plus
	li $v0, 5                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save addend to stack
	# begin times
	li $v0, 3                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save multiplicand to stack
	li $v0, 2                               # move int val to $v0
	lw $t1, ($sp)                           # load multiplicand from stack
	addu $sp, $sp, 4                        # pop multiplicand from stack
	mul $v0, $t1, $v0                       # calculate product
	# end times
	lw $t1, ($sp)                           # load addend from stack
	addu $sp, $sp, 4                        # pop addend from stack
	add $v0, $t1, $v0                       # calculate sum
	# end plus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save minuend to stack
	li $v0, 4                               # move int val to $v0
	lw $t1, ($sp)                           # load minuend from stack
	addu $sp, $sp, 4                        # pop minuend from stack
	sub $v0, $t1, $v0                       # calculate difference
	# end minus
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	# end print
	# begin epilogue -- main
	lw $ra, -4($fp)                         # restore return address
	lw $fp, -12($fp)                        # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	# end epilogue -- main
	li $v0, 10                              # set syscall to exit
	syscall                                 # exit
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


