	.text
	.globl main
main:
	# begin prologue -- main
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set main's frame pointer
	# end prologue -- main
	# start lessThan
	li $v0, 42                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	li $v0, 37                              # move int val to $v0
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	beqz $v0, ifFalse3                      # if false, goto branch 'ifFalse3'
	# begin println
	li $v0, 0                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone3
ifFalse3:
	# start lessThan
	li $v0, 42                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	li $v0, 42                              # move int val to $v0
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	beqz $v0, ifFalse4                      # if false, goto branch 'ifFalse4'
	# begin println
	li $v0, 1                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone4
ifFalse4:
	# start lessThan
	li $v0, 37                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	li $v0, 42                              # move int val to $v0
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	beqz $v0, ifFalse5                      # if false, goto branch 'ifFalse5'
	# begin println
	li $v0, 2                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone5
ifFalse5:
	# begin println
	li $v0, 3                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
isDone5:
isDone4:
isDone3:
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


