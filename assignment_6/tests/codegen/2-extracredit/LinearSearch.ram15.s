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
	jal Start
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
	addi $v0, $fp, null
	addi $v0, $fp, null
Start:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	addi $v0, $fp, 4
	addi $v0, $fp, -16
	addi $v0, $fp, -20
	# start Call
	addi $v0, $fp, 4
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	jal Init
	addi $sp, $sp, 4
	# end Call
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# start Call
	jal Print
	addi $sp, $sp, 4
	# end Call
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -20
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# begin Println
	li $v0, 9999
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	# begin Println
	# start Call
	li $v0, 8
	subu $sp, $sp, 4
	sw $v0, ($sp)
	jal Search
	addi $sp, $sp, 4
	# end Call
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	# begin Println
	# start Call
	li $v0, 12
	subu $sp, $sp, 4
	sw $v0, ($sp)
	jal Search
	addi $sp, $sp, 4
	# end Call
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	# begin Println
	# start Call
	li $v0, 17
	subu $sp, $sp, 4
	sw $v0, ($sp)
	jal Search
	addi $sp, $sp, 4
	# end Call
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	# begin Println
	# start Call
	li $v0, 50
	subu $sp, $sp, 4
	sw $v0, ($sp)
	jal Search
	addi $sp, $sp, 4
	# end Call
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	li $v0, 55
	lw $ra, -12($fp)
	lw $fp, -4($fp)
	addi $sp, $sp, 16
	jr $ra
Print:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	addi $v0, $fp, -16
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# start LessThan
	addi $v0, $fp, -16
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	# begin Println
	addi $v0, $fp, -16
	lw $v0, ($v0)
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	addi $v0, $fp, -16
	li $v0, 1
	li $v0, 0
	lw $ra, -12($fp)
	lw $fp, -4($fp)
	addi $sp, $sp, 16
	jr $ra
Search:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	addi $v0, $fp, 4
	addi $v0, $fp, -16
	addi $v0, $fp, -20
	addi $v0, $fp, -24
	addi $v0, $fp, -28
	addi $v0, $fp, -32
	addi $v0, $fp, -36
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	li $v0, 0
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -20
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	li $v0, 0
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -24
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# start LessThan
	addi $v0, $fp, -16
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	addi $v0, $fp, -16
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -28
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# begin Plus
	addi $v0, $fp, 4
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 1
	lw $t1, ($sp)
	addu $sp, $sp, 4
	add $v0, $t1, $v0
	# end Plus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -32
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# start LessThan
	addi $v0, $fp, -28
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, 4
	lw $v0, ($v0)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	beqz $v0, ifFalse13
	li $v0, 0
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -36
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	j isDone13
ifFalse13:
	# start Not
	xori $v0, $v0, 1
	# end Not
	beqz $v0, ifFalse14
	li $v0, 0
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -36
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	j isDone14
ifFalse14:
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -20
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -24
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
isDone14:
isDone13:
	# begin Plus
	addi $v0, $fp, -16
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 1
	lw $t1, ($sp)
	addu $sp, $sp, 4
	add $v0, $t1, $v0
	# end Plus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	addi $v0, $fp, -24
	lw $v0, ($v0)
	lw $ra, -12($fp)
	lw $fp, -4($fp)
	addi $sp, $sp, 16
	jr $ra
Init:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	addi $v0, $fp, 4
	addi $v0, $fp, -16
	addi $v0, $fp, -20
	addi $v0, $fp, -24
	addi $v0, $fp, -28
	addi $v0, $fp, 4
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	addi $v0, $fp, 4
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# begin Plus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 1
	lw $t1, ($sp)
	addu $sp, $sp, 4
	add $v0, $t1, $v0
	# end Plus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -20
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# start LessThan
	addi $v0, $fp, -16
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	# begin Times
	li $v0, 2
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -16
	lw $v0, ($v0)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	mul $v0, $t1, $v0
	# end Times
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -24
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	# begin Minus
	addi $v0, $fp, -20
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 3
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sub $v0, $t1, $v0
	# end Minus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -28
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	addi $v0, $fp, -16
	lw $v0, ($v0)
	# begin Plus
	addi $v0, $fp, -24
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -28
	lw $v0, ($v0)
	lw $t1, ($sp)
	addu $sp, $sp, 4
	add $v0, $t1, $v0
	# end Plus
	addi $v0, $fp, -16
	li $v0, 1
	# begin Minus
	addi $v0, $fp, -20
	lw $v0, ($v0)
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 1
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sub $v0, $t1, $v0
	# end Minus
	subu $sp, $sp, 4
	sw $v0, ($sp)
	addi $v0, $fp, -20
	lw $t1, ($sp)
	addu $sp, $sp, 4
	sw $t1, ($v0)
	li $v0, 0
	lw $ra, -12($fp)
	lw $fp, -4($fp)
	addi $sp, $sp, 16
	jr $ra
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


