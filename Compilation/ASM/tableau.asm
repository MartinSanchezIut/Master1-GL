.data
array: .space 16

.text
main :
	li $s0, 6
	li $s1, 7
	li $s2, 8
	li $s3, 9


	li $t0, 0
	sw $s0, array($t0)
	
	addi $t0, $t0, 4
	sw $s1, array($t0)
	
	addi $t0, $t0, 4
	sw $s2, array($t0)
	
	addi $t0, $t0, 4
	sw $s3, array($t0)

	lw $s4, array+4
	lw $s5, array
	
	sw $s5, array+4
	sw $s4, array