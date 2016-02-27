main:
    # int i = 0
    addi $t0, $zero, 0

    # int result = 0
    addi $t0, $zero, 0

    bgt $t0, 10, loop

    li $v0, 1
    syscall

loop:
