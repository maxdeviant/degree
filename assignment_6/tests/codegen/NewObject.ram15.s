	.text
	.globl main
main:
	#begin prologue -- main
	subu $sp, $sp, 24    # stack frame is at least 24 bytes
	sw $fp, 4($sp)       # save caller's frame pointer
	sw $ra, 0($sp)       # save return address
	addi $fp, $sp, 20    # set up main's frame pointer
	#end prologue -- main
	#caller NewObject.main preparing for function call
	sw $ra, -20($fp)       # save return address
	li $a0, 1     # new object has 1 fields
	mul $a0, $a0, 4        # each field is given 4 bytes
	li $v0, 9              # load 9 into $v0 for syscall
	syscall                # allocates $a0 amount of memory, returns ptr via $v0
	move $a0, $v0            # store arg0 ("this") in reg $a0
	sw $v0, -16($sp)          # also store arg0 - address of this - in stack
	jal C.testing           # method call -- jump to C.testing
	#execution back in caller NewObject.main
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
C.testing:
	#begin prologue -- C.testing
	subu $sp, $sp, 24   # stack frame push 24 bytes onto stack
	sw $fp, 4($sp)       # save frame pointer
	sw $ra, 0($sp)       # save return address
	addi $fp, $sp, 20       # set up frame pointer
	#end prologue -- C.testing
	li $v0, 123        # load literal 123 into $v0
	#begin epilogue -- C.testing
	lw $ra, -20($fp)     # restore return address
	lw $fp, -16($fp)     # restore frame pointer
	addi $sp, $sp, 24       # pop the stack
	#end epilogue -- C.testing
	jr $ra
	
	.data


