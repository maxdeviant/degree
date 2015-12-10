	.text
	.globl main
main:
	# begin prologue -- main
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set main's frame pointer
	# end prologue -- main
	# start not
	li $v0, 1                               # move true val to $v0
	xori $v0, $v0, 1                        # calculate not
	# end not
	beqz $v0, ifFalse6                      # if false, goto branch 'ifFalse6'
	# begin println
	li $v0, 0                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone6
ifFalse6:
	# start not
	li $v0, 0                               # move false val to $v0
	xori $v0, $v0, 1                        # calculate not
	# end not
	beqz $v0, ifFalse7                      # if false, goto branch 'ifFalse7'
	# begin println
	li $v0, 1                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	j isDone7
ifFalse7:
	# begin println
	li $v0, 2                               # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
isDone7:
isDone6:
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


