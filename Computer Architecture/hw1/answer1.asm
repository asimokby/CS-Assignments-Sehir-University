.text 
	
	
	add $s0, $zero, $zero # sum = 0
	addi $t0, $zero, 1   # x = 1
while1: slti $t2, $t0, 10   
    	beq $t2, $zero, exit2
    	add $t1, $zero, $zero # y = 0
    	
while2: slt $t2, $t0, $t1
    	bne $t2, $zero, exit1 
    	add $s0, $s0, $t1 # sum += y 
    	addi $t1, $t1, 1  # y += 1
    	j while2
    		 	
 exit1: 
 	addi $t0, $t0, 2 # x += 2
    	j while1  
    	
 exit2:  
 
