#A�list is defined here
.data
my_array: .word 38, 3, 71, 16, 12, 4, 8, 1, 18, 83

.text
la $s0, my_array    # based address of list loaded into $s0
addi $s1, $zero, 10 # $s1 is set to the size of the list. If you change the size of my_array, change this number accordingly  

# Now you have the base address and the size of the list
# You should be able to reverse the numbers in list
# Continue to write your code here


	add $t0, $zero, $zero  # i = 0
	srl $t1, $s1, 1 # len(my_array)/ 2 
	
while: 	slt $t2, $t0, $t1 # i < (len(my_array)/2)
	beq $t2, $zero, exit
	
	sll $t3, $t0, 2
	add $t3, $t3, $s0 
	lw $t4, 0($t3) # t4 = my_array[i]
	
	sub $t5, $s1, $t0 # len(my_array) - i 
	addi $t5, $t5, -1 #  t5 = len(my_array) - i - 1
	sll $t6, $t5, 2  
	add $t6, $t6, $s0
	lw $t7, 0($t6)  # t7 = my_array[len(my_array)-i-1)]

	sw $t4, 0($t6) # my_array[len(my_array)-i-1)] = my_array[i]
	sw $t7, 0($t3) # my_array[i] = my_array[len(my_array)-i-1)]
	
	
	addi $t0, $t0, 1 # i ++
	j while 
exit: 
	

