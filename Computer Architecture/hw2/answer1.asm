#A list is defined here
.data
my_array: .word 10, 9, 2, 3, 1, 4, 6, 7, 32
.text
la $s0, my_array    # based address of list loaded into $s0
addi $s1, $zero, 9  # $s1 is set to the size of the list. If you change the size of my_array, change this number accordingly   

# Now you have the size and the base address of the list
# Continue to write your code here

	addi $t0, $zero, 0  # i = 0
while1: slt $t3, $t0, $s1   # i < len(A)
	beq $t3, $zero, exitWhile1
	
	add $t2, $zero, $t0 # min_idx = i 
	addi $t1, $t0, 1  #j = i + 1
	
	while2: slt $t3, $t1, $s1 
		beq $t3, $zero, exitWhile2
		
		sll $t3, $t1, 2
		add $t3, $t3, $s0
		lw $t4, 0($t3) #t4 = A[j]
		
		sll $t3, $t2, 2
		add $t3, $t3, $s0 
		lw $t5, 0($t3) #t5 = A[min_idx]
		
		slt $t3, $t4, $t5 # A[j] < A[min_idx]
		beq $t3, $zero, exitIf
		
		add $t2, $zero, $t1 # min_idx = j 
		
		exitIf: addi $t1, $t1, 1
			j while2
			
	exitWhile2: sll $t3, $t0, 2
		    add $t3, $t3, $s0 #t3 = &A[i] 
		    lw $t6, 0($t3)  #t6 = A[i]
		    
		    #using last found min_idx to get A[min_idx] 
		    sll $t7, $t2, 2
		    add $t7, $t7, $s0 
		    lw $t5, 0($t7) #t5 = A[min_idx]
		    
		    sw $t5, 0($t3)  #A[i] = A[min_idx]
		    sw $t6, 0($t7)  #A[min_idx] = A[i]
		   
		    add $t0, $t0, 1 #i += 1
		    j while1

exitWhile1: 
	   srl $t3, $s1, 1
	   sll $t4, $t3, 2 
	   add $t4, $t4, $s0
	   lw $s2, 0($t4)  # s2 = A[len(A)/2]
	   
	
		
		
		
		
		
		
		
		
