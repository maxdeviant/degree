	.text
	.globl main
main:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	# start LessThan
	li $v0, 42
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 37
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	beqz $v0, ifFalse3
	# begin Println
	li $v0, 0
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone3
ifFalse3:
	# start LessThan
	li $v0, 42
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 42
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	beqz $v0, ifFalse4
	# begin Println
	li $v0, 1
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone4
ifFalse4:
	# start LessThan
	li $v0, 37
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 42
	lw $t1, ($sp)
	addu $sp, $sp, 4
	slt $v0, $t1, $v0
	# end LessThan
	beqz $v0, ifFalse5
	# begin Println
	li $v0, 2
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone5
ifFalse5:
	# begin Println
	li $v0, 3
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
isDone5:
isDone4:
isDone3:
	lw $ra, -4($fp)
	lw $fp, -12($fp)
	addi $sp, $sp, 16
	li $v0, 10
	syscall
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


