import java.util.*;

public class Tutorial3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //Example 1: print a 5 row, 10 column grid of *

        //outer loop: step through rows
            //inner loop: step through columns 

        /* 
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= 10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        */

        //Example 2: print a 12 x 12 multiplication table
        /*
        1 2 3 . . . 12
        2 4 6 . . . 24
        . . .
        12 24 36 ... 144
        */

        //each number to take digit/digit/space
        /* 
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                int num = i * j;

                
                //is it 1, 2, or 3 digits?
                if (num < 10) {
                    System.out.printf(" %d  ", num);
                }
                else if (num < 100) {
                    System.out.printf(" %d ", num);
                }
                else {
                    System.out.printf(" %d", num);
                }

            }
            System.out.println();
        }
        */

        //Example 3: repetition loop of FizzBuzz Example
        char again;
        int num;

        do{
            System.out.print("Enter a positive integer: ");
            num = Integer.parseInt(s.nextLine());
            if (num >= 1) {
            for (int cur = 1; cur <= num; cur ++) {
                if (cur % 3 == 0 && cur % 5 == 0) {
                    System.out.println("FizzBuzz");
                    System.out.println("Another");
                }
                else if (cur % 3 == 0) {//we know here it can't be divisible by both
                    System.out.println("Fizz");
                }
                else if (cur % 5 ==0) {
                    System.out.println("Buzz");
                }
                else{
                    System.out.println(cur);
                }
            }
        }
            else {
                System.out.printf("Error. %d is not positive (needs to be 1 or bigger).", num);
            }
        //ask them if they want to do it again?
            System.out.print("\nDo you want to go again? (type y to repeat): ");
            again = s.nextLine().toLowerCase().charAt(0);
            
        } while (again == 'y');
    }
}