main:
    # int i = 0
    addi $t0, $zero, 0

    # int result = 0
    addi $t1, $zero, 0

    addi $t0, $t0, 2

    add $t1, $t1, $t0

    li  $a0, $t1

    li $v0, 1
    syscall
