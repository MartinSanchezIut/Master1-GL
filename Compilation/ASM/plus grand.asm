.text
main:   li $v0, 5
	syscall
	move $t1, $v0
	
	li $t0, 0

loop:	bgt $t0, $t1 end
	
	li $v0, 1
	move $a0, $t0
	syscall 
	addi $t0, $t0, 1
	j loop
end: 