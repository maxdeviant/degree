	.text
	.globl main
main:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	# begin Print
	# begin Minus
	# begin Plus
	li $v0, 5
	subu $sp, $sp, 4
	sw $v0, ($sp)
	# begin Times
	li $v0, 3
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 2
	lw $t1, ($sp)
	addu $sp, $sp, 4
	mul $v0, $t1, $v0
	# end Times
	lw $t1, ($sp)
	addu $sp, $sp, 4
	add $v0, $t1, $v0
	# end Plus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 4
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sub $v0, $t1, $v0
	# end Minus
	move $a0, $v0
	li $v0, 1
	syscall
	# end Print
	lw $ra, -4($fp)
	lw $fp, -12($fp)
	addi $sp, $sp, 16
	li $v0, 10
	syscall
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


