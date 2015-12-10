	.text
	.globl main
main:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	# begin Print
	li $v0, 5
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


