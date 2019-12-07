#A�list is defined here
.data
my_array: .word 10, 9, 2, 3, 1, 4, 6, 7, 32
.text
la $s0, my_array    # based address of list loaded into $s0
addi $s1, $zero, 9  # $s1 is set to the size of the list. If you change the size of my_array, change this number accordingly   

# Now you have the size and the base address of the list
# You should be able to find the difference between maximum and minimum elements in the list.
# Continue to write your code here




	
	lw $t0, 0($s0) # maxa = a[0]
	lw $t1, 0($s0) # min = a[0]	
	add $t2, $zero, $zero  # i = 0
while:	slt $t3, $t2, $s1 # i < len(a)
	beq $t3, $zero, exit2 # go to exit if i  not <  len(a)
	
	sll $t3, $t2, 2  
	add $t3, $t3, $s0
	lw $t4, 0($t3) # t5 = a[i]
	
    if: slt $t3, $t4, $t1   #a[i] < min
    	beq $t3, $zero, elif
    	add $t1, $zero, $t4
    	j exit1 
    	
  elif: slt $t3, $t0, $t4   #max < a[i]
  	beq $t3, $zero, exit1
	add $t0, $zero, $t4

exit1:	addi $t2, $t2, 1
	j while 
	
exit2:  sub $s2, $t0, $t1 
	
	
	
	
	
