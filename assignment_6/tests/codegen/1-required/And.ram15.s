	.text
	.globl main
main:
	# begin prologue -- main
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set main's frame pointer
	# end prologue -- main
	# start and
	li $v0, 0                               # move false val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save bool to stack
	li $v0, 0                               # move false val to $v0
	lw $t1, ($sp)                           # load bool from stack
	addu $sp, $sp, 4                        # pop bool from stack
	and $v0, $t1, $v0                       # calculate and
	# end and
	beqz $v0, ifFalse0                      # if false, goto branch 'ifFalse0'
	# begin println
	li $v0, 0                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone0
ifFalse0:
	# start and
	li $v0, 0                               # move false val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save bool to stack
	li $v0, 1                               # move true val to $v0
	lw $t1, ($sp)                           # load bool from stack
	addu $sp, $sp, 4                        # pop bool from stack
	and $v0, $t1, $v0                       # calculate and
	# end and
	beqz $v0, ifFalse1                      # if false, goto branch 'ifFalse1'
	# begin println
	li $v0, 1                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone1
ifFalse1:
	# start and
	li $v0, 1                               # move true val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save bool to stack
	li $v0, 0                               # move false val to $v0
	lw $t1, ($sp)                           # load bool from stack
	addu $sp, $sp, 4                        # pop bool from stack
	and $v0, $t1, $v0                       # calculate and
	# end and
	beqz $v0, ifFalse2                      # if false, goto branch 'ifFalse2'
	# begin println
	li $v0, 2                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone2
ifFalse2:
	# begin println
	li $v0, 3                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
isDone2:
isDone1:
isDone0:
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


