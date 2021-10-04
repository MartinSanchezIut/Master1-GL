.data
pair: .asciiz "Ouais c'est pair le couz\n"
inpair: .asciiz "Non c'est pas pair le couz\n"

.text 
main:   li $v0, 5
	syscall
	move $t0, $v0
	
	
	

inpair:	li $v0, 4
	la $a0, inpair
	syscall 
	j end
	
pair:	li $v0, 4
	la $a0, pair
	syscall 
	
end: 