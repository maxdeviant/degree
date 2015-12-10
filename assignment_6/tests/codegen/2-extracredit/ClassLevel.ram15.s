	.text
	.globl main
main:
	# begin prologue -- main
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set main's frame pointer
	# end prologue -- main
	# begin println
	# start call
	li $v0, 4                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal helper                              # jump to helper
	addi $sp, $sp, 4                        # pop the stack
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	# begin epilogue -- main
	lw $ra, -4($fp)                         # restore return address
	lw $fp, -12($fp)                        # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	# end epilogue -- main
	li $v0, 10                              # set syscall to exit
	syscall                                 # exit
	addi $v0, $fp, null                     # save memory location of identifier to $v0
	addi $v0, $fp, null                     # save memory location of identifier to $v0
helper:
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set helper's frame pointer
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	li $v0, 5                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# begin times
	li $v0, 4                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save multiplicand to stack
	lw $t1, ($sp)                           # load multiplicand from stack
	addu $sp, $sp, 4                        # pop multiplicand from stack
	mul $v0, $t1, $v0                       # calculate product
	# end times
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	li $v0, 1                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# begin minus
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save minuend to stack
	lw $t1, ($sp)                           # load minuend from stack
	addu $sp, $sp, 4                        # pop minuend from stack
	sub $v0, $t1, $v0                       # calculate difference
	# end minus
	lw $ra, -12($fp)                        # restore return address
	lw $fp, -4($fp)                         # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	jr $ra                                  # jump to previous call
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


