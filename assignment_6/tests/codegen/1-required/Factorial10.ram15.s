	.text
	.globl main
main:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	# begin Println
	# start Call
	li $v0, 10
	subu $sp, $sp, 4
	sw $v0, ($sp)
	jal ComputeFac
	addi $sp, $sp, 4
	# end Call
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	lw $ra, -4($fp)
	lw $fp, -12($fp)
	addi $sp, $sp, 16
	li $v0, 10
	syscall
ComputeFac:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	addi $v0, $fp, 4
	addi $v0, $fp, -16
	# start LessThan
	addi $v0, $fp, 4
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 1
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	beqz $v0, ifFalse12
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	j isDone12
ifFalse12:
	# begin Times
	addi $v0, $fp, 4
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	mul $v0, $t1, $v0
	# end Times
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
isDone12:
	addi $v0, $fp, -16
	lw $v0, ($v0)
	lw $ra, -12($fp)
	lw $fp, -4($fp)
	addi $sp, $sp, 16
	jr $ra
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


