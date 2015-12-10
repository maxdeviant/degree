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
	li $v0, 10                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal Start                               # jump to Start
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
	addi $v0, $fp, null                     # save memory location of identifier to $v0
	addi $v0, $fp, null                     # save memory location of identifier to $v0
Start:
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set Start's frame pointer
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	# start call
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal Init                                # jump to Init
	addi $sp, $sp, 4                        # pop the stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# start call
	jal Print                               # jump to Print
	addi $sp, $sp, 4                        # pop the stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# begin println
	li $v0, 9999                            # move int val to $v0
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	# begin println
	# start call
	li $v0, 8                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal Search                              # jump to Search
	addi $sp, $sp, 4                        # pop the stack
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	# begin println
	# start call
	li $v0, 12                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal Search                              # jump to Search
	addi $sp, $sp, 4                        # pop the stack
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	# begin println
	# start call
	li $v0, 17                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal Search                              # jump to Search
	addi $sp, $sp, 4                        # pop the stack
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	# begin println
	# start call
	li $v0, 50                              # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save arg to stack
	jal Search                              # jump to Search
	addi $sp, $sp, 4                        # pop the stack
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	li $v0, 55                              # move int val to $v0
	lw $ra, -12($fp)                        # restore return address
	lw $fp, -4($fp)                         # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	jr $ra                                  # jump to previous call
Print:
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set Print's frame pointer
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	li $v0, 1                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# start lessThan
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	# begin println
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	move $a0, $v0                           # move int to syscall arg
	li $v0, 1                               # set syscall to print int
	syscall                                 # print int
	la $a0, newline                         # move newline to syscall arg
	li $v0, 4                               # set syscall to print string
	syscall                                 # print newline
	# end println
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	li $v0, 1                               # move int val to $v0
	li $v0, 0                               # move int val to $v0
	lw $ra, -12($fp)                        # restore return address
	lw $fp, -4($fp)                         # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	jr $ra                                  # jump to previous call
Search:
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set Search's frame pointer
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	addi $v0, $fp, -28                      # save memory location of identifier to $v0
	addi $v0, $fp, -32                      # save memory location of identifier to $v0
	addi $v0, $fp, -36                      # save memory location of identifier to $v0
	li $v0, 1                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	li $v0, 0                               # move false val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	li $v0, 0                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# start lessThan
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -28                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# begin plus
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save addend to stack
	li $v0, 1                               # move int val to $v0
	lw $t1, ($sp)                           # load addend from stack
	addu $sp, $sp, 4                        # pop addend from stack
	add $v0, $t1, $v0                       # calculate sum
	# end plus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -32                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# start lessThan
	addi $v0, $fp, -28                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	beqz $v0, ifFalse13                     # if false, goto branch 'ifFalse13'
	li $v0, 0                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -36                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	j isDone13
ifFalse13:
	# start not
	xori $v0, $v0, 1                        # calculate not
	# end not
	beqz $v0, ifFalse14                     # if false, goto branch 'ifFalse14'
	li $v0, 0                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -36                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	j isDone14
ifFalse14:
	li $v0, 1                               # move true val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	li $v0, 1                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
isDone14:
isDone13:
	# begin plus
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save addend to stack
	li $v0, 1                               # move int val to $v0
	lw $t1, ($sp)                           # load addend from stack
	addu $sp, $sp, 4                        # pop addend from stack
	add $v0, $t1, $v0                       # calculate sum
	# end plus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	lw $ra, -12($fp)                        # restore return address
	lw $fp, -4($fp)                         # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	jr $ra                                  # jump to previous call
Init:
	subu $sp, $sp, 16                       # stack frame is at least 16 bytes
	sw $fp, 8($sp)                          # save caller's frame pointer
	sw $ra, 0($sp)                          # save return address
	addu $fp, $sp, 12                       # set Init's frame pointer
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	addi $v0, $fp, -28                      # save memory location of identifier to $v0
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	addi $v0, $fp, 4                        # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	li $v0, 1                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# begin plus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save addend to stack
	li $v0, 1                               # move int val to $v0
	lw $t1, ($sp)                           # load addend from stack
	addu $sp, $sp, 4                        # pop addend from stack
	add $v0, $t1, $v0                       # calculate sum
	# end plus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# start lessThan
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save int to stack
	lw $t1, ($sp)                           # load int from stack
	addu $sp, $sp, 4                        # pop int from stack
	slt $v0, $t1, $v0                       # calculate lessThan
	# end lessThan
	# begin times
	li $v0, 2                               # move int val to $v0
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save multiplicand to stack
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	lw $t1, ($sp)                           # load multiplicand from stack
	addu $sp, $sp, 4                        # pop multiplicand from stack
	mul $v0, $t1, $v0                       # calculate product
	# end times
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	# begin minus
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save minuend to stack
	li $v0, 3                               # move int val to $v0
	lw $t1, ($sp)                           # load minuend from stack
	addu $sp, $sp, 4                        # pop minuend from stack
	sub $v0, $t1, $v0                       # calculate difference
	# end minus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -28                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	# begin plus
	addi $v0, $fp, -24                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save addend to stack
	addi $v0, $fp, -28                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	lw $t1, ($sp)                           # load addend from stack
	addu $sp, $sp, 4                        # pop addend from stack
	add $v0, $t1, $v0                       # calculate sum
	# end plus
	addi $v0, $fp, -16                      # save memory location of identifier to $v0
	li $v0, 1                               # move int val to $v0
	# begin minus
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $v0, ($v0)                           # load identifier from stack
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save minuend to stack
	li $v0, 1                               # move int val to $v0
	lw $t1, ($sp)                           # load minuend from stack
	addu $sp, $sp, 4                        # pop minuend from stack
	sub $v0, $t1, $v0                       # calculate difference
	# end minus
	subu $sp, $sp, 4                        # increase stack by one word
	sw $v0, ($sp)                           # save exp result to stack
	addi $v0, $fp, -20                      # save memory location of identifier to $v0
	lw $t1, ($sp)                           # load exp result from stack
	addu $sp, $sp, 4                        # pop exp result from stack
	sw $t1, ($v0)                           # assign value to memory address of identifier
	li $v0, 0                               # move int val to $v0
	lw $ra, -12($fp)                        # restore return address
	lw $fp, -4($fp)                         # restore caller's frame pointer
	addi $sp, $sp, 16                       # pop the stack
	jr $ra                                  # jump to previous call
	
	.data
newline: .asciiz "\n"
space: .asciiz " "


