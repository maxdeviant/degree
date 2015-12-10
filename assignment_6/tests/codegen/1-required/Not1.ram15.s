	.text
	.globl main
main:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	# start Not
	li $v0, 1
	xori $v0, $v0, 1
	# end Not
	beqz $v0, ifFalse6
	# begin Println
	li $v0, 0
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone6
ifFalse6:
	# start Not
	li $v0, 0
	xori $v0, $v0, 1
	# end Not
	beqz $v0, ifFalse7
	# begin Println
	li $v0, 1
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone7
ifFalse7:
	# begin Println
	li $v0, 2
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
isDone7:
isDone6:
	lw $ra, -4($fp)
	lw $fp, -12($fp)
	addi $sp, $sp, 16
	li $v0, 10
	syscall
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


