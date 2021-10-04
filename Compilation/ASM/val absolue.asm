.text
main:   li $v0, 5
	syscall
	move $t1, $v0
	
	bltz $t1, negative
	
	li $v0, 1
	move $a0, $t1
	syscall 
	j end	
	

negative:
	#li $t2, -1
	#mul $t1, $t1, $t2
	neg $t1, $t1
	li $v0, 1
	move $a0, $t1
	syscall 
	j end

end:    li $v0, 10 
	syscall
