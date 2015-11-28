	.text
	.globl main
main:
	#begin prologue -- main
	subu $sp, $sp, 24    # stack frame is at least 24 bytes
	sw $fp, 4($sp)       # save caller's frame pointer
	sw $ra, 0($sp)       # save return address
	addi $fp, $sp, 20    # set up main's frame pointer
	#end prologue -- main
	#caller MethodCall.main preparing for function call
	sw $ra, -20($fp)       # save return address
	li $v0, 4        # load literal 4 into $v0
	move $a1, $v0          # store arg1 in reg $a1
	sw $v0, -12($sp)           # also store arg1 in stack
	li $a0, 1     # new object has 1 fields
	mul $a0, $a0, 4        # each field is given 4 bytes
	li $v0, 9              # load 9 into $v0 for syscall
	syscall                # allocates $a0 amount of memory, returns ptr via $v0
	move $a0, $v0            # store arg0 ("this") in reg $a0
	sw $v0, -16($sp)          # also store arg0 - address of this - in stack
	jal A.helper           # method call -- jump to A.helper
	#execution back in caller MethodCall.main
	lw $ra, -20($fp)       # restore return address
	move $a0, $v0         # move print_arg to $a0
	li $v0, 1             # system call code for print_int
	syscall
	#begin epilogue -- main
	lw $ra, 0($sp)       # restore return address
	lw $fp, 4($sp)       # restore caller's frame pointer
	addi $sp, $sp, 24    # pop the stack
	#end epilogue -- main
	li $v0, 10
	syscall
A.helper:
	#begin prologue -- A.helper
	subu $sp, $sp, 28   # stack frame push 28 bytes onto stack
	sw $fp, 8($sp)       # save frame pointer
	sw $ra, 4($sp)       # save return address
	addi $fp, $sp, 24       # set up frame pointer
	#end prologue -- A.helper
	li $v0, 4        # load literal 4 into $v0
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # push v0 onto stack
	lw $v0, -8($fp)      # load offset of parameter syntaxtree.IdentifierExp@7568578b into $v0
	lw $v1, 0($sp)         # pop stack value into $v1
	addi $sp, $sp, 4       # ...stack pop
	mul $v0, $v1, $v0      # multiply
	subu $sp, $sp, 4       # stack push...
	sw $v0, 0($sp)         # push v0 onto stack
	add $v0, $fp, -24      # load addr of local variable b into $v0
	lw $v1, 0($sp)         # pop stack value into $v1
	addi $sp, $sp, 4       # ...stack pop
	sw $v1, 0($v0)         # assign value in $v1 into addr in $v0
	lw $v0, -24($fp)      # load offset of local variable syntaxtree.IdentifierExp@5a6b4e7e into $v0
	#begin epilogue -- A.helper
	lw $ra, -20($fp)     # restore return address
	lw $fp, -16($fp)     # restore frame pointer
	addi $sp, $sp, 28       # pop the stack
	#end epilogue -- A.helper
	jr $ra
	
	.data


