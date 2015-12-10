	.text
	.globl main
main:
	subu $sp, $sp, 16
	sw $fp, 8($sp)
	sw $ra, 0($sp)
	addu $fp, $sp, 12
	# start And
	li $v0, 0
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 0
	lw $t1, ($sp)
	addu $sp, $sp, 4
	and $v0, $t1, $v0
	# end And
	beqz $v0, ifFalse0
	# begin Println
	li $v0, 0
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone0
ifFalse0:
	# start And
	li $v0, 0
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 1
	lw $t1, ($sp)
	addu $sp, $sp, 4
	and $v0, $t1, $v0
	# end And
	beqz $v0, ifFalse1
	# begin Println
	li $v0, 1
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone1
ifFalse1:
	# start And
	li $v0, 1
	subu $sp, $sp, 4
	sw $v0, ($sp)
	li $v0, 0
	lw $t1, ($sp)
	addu $sp, $sp, 4
	and $v0, $t1, $v0
	# end And
	beqz $v0, ifFalse2
	# begin Println
	li $v0, 2
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
	j isDone2
ifFalse2:
	# begin Println
	li $v0, 3
	move $a0, $v0
	li $v0, 1
	syscall
	la $a0, newline
	li $v0, 4
	syscall
	# end Println
isDone2:
isDone1:
isDone0:
	lw $ra, -4($fp)
	lw $fp, -12($fp)
	addi $sp, $sp, 16
	li $v0, 10
	syscall
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


