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
	jal testing                             # jump to testing
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
testing:
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set testing's frame pointer
	li $v0, 123                             # move int val to $v0
	lw $ra, -12($fp)                        # restore return address
	lw $fp, -4($fp)                         # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	jr $ra                                  # jump to previous call
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


