#include <stdio.h>
#include <math.h>

// question 1 
void question1(){
    printf("    The smallest number is: ");
    #define TRUE 1
    int current_num = 10;
    int number, arm_strong, digit;
    while (TRUE){
        number = current_num;
        arm_strong = 0;
        while (number> 0){
            digit = number % 10;
            arm_strong = (digit*digit*digit) + arm_strong;
            number = number / 10;
        }
        if (arm_strong == current_num){
            printf("%d \n", arm_strong);
            break;
        }
        current_num += 1;
    }
}


// question 2

void question2(){
    
    int n;
    char c;
    printf("    Enter a number here:");
    scanf ("%d",&n); //assign memory address to of n to n! 
    printf("    Enter a charachter here:");
    scanf(" %c",&c); //getting char from user 

    //drawing the top part 
    for (int r = 0; r < n+1;r++ ){
        for (int i= 0; i < n-r;i++){
            printf(". ");
        }
        for (int j = 0; j < r*2+1; j++){
            printf("%c ", c);
        }
        for (int k= 0; k < n-r;k++){
            printf(". ");
        }
        printf("\n");
    }
    //drawing the bottom part 
   for (int r = 0; r < n;r++ ){
        for (int i= 0; i < r+1;i++){
            printf(". ");
        }
        for (int j = n*2-1; j > r*2; j--){
            printf("%c ", c);
        }
        for (int k= 0; k < r+1;k++){
            printf(". ");
        }
        printf("\n");
    }
}

// question 3
void question3(){
    float n;
    int en;
    float a[] = {200.0, 100.0, 50.0, 20.0, 10.0, 5.0, 1.0, .50, .25, .10, .05, .01};
    printf("    Enter an amount in double, for example 11.56: ");
    scanf ("%g",&n); //assign memory address to of n to n!
    printf("\n    Your amount %g consists of \n", n);

    for (int i = 0; i < 12; i++){
        if (i <= 6){
            en = floor(n/a[i]);
            n = n - (en*a[i]);
            printf("    %d  %gTLs \n",en, a[i]);
        } else{
            float fordisplay  = a[i]*100;
            //rounding to the hundredth! because of the precision issue! 
            int c, r, m;
            m =  n*1000; 
            c = m%10; 
            r = m/10; 
            if(c>=5) r++;
            n = (float)r/100;
            en = n/a[i];
            n = n - (en*(a[i]));
            printf("    %d  %gKrs \n",en, fordisplay);
        }
    }
}






int main(){

    printf("Question 1 \n");
    question1();
    printf("Question 2 \n");
    question2();
    printf("Question 3 \n");
    question3();

    return 0;
}