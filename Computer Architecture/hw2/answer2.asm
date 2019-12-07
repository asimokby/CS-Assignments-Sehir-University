#A list is defined here
.data
my_array: .word 2, 5, 7, 8, 12, 17, 21
.text
la $s0, my_array    # based address of list loaded into $s0
addi $s1, $zero, 7 # $s1 is set to the size of the list. If you change the size of my_array, change this number accordingly  

# Now you have the base address and the size of the list
# Continue to write your code here


addi $t2, $zero, 0  #i = 0    	       
addi $s2, $zero, 0  # max = 0 
while1: slt $t3, $t2, $s1
       beq $t3, $zero, exit
       sll $t3, $t2, 2 
       add $t3, $t3, $s0 
       lw  $t4, 0($t3) #t4 = A[i] = temp 
       add $a0, $zero, $t4  
       jal find_steps
       add $t5, $v0, $zero 
       slt $t6, $s2, $t5  # max < temp 
       beq $t6, $zero, exitIf1
       add $s2, $t5, $zero  #max = temp 
       exitIf1: add $t2, $t2, 1
                 j while1     

 
find_steps: add $t0, $zero, $zero  # step = 0 = t0 
       while: addi $t1, $zero, 1   #t1 = 1 
	      beq $a0, $t1, exitWhile 
	      addi $t1, $zero, 2  #t1 = 2 
	    	   div $a0, $t1  
	    	   mfhi $t1   #t1 = x % 2 
	    	   bne $t1, $zero, else
	    	   srl $a0, $a0, 1  #x = x/2
	    	   j exitIf 
	     else: addi $t1, $zero, 3  #t1 = 3
	    	   mul $t1, $t1, $a0 
	    	   addi $a0, $t1, 1 
	   exitIf: addi $t0, $t0, 1 
	     	   j while
        exitWhile: add $v0, $zero, $t0 
	    	   jr $ra
	    	       
       
exit:       	
       
       


	     	     
	     
	    	   
