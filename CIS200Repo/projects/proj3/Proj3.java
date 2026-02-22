import java.util.*;
 
/**
* Prime factorization calculator
* 
*
* @author Kate Kendig
* @version Proj 3
*/
 
public class Proj3{
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
 
        //get num = ?
        System.out.print("Enter a positive whole number: ");
        int num = Integer.parseInt(s.nextLine());
        //input handling for nonpositive values
        while (num <= 0){
            System.out.print("Input was not positive. Enter a positive whole number: ");
            num = Integer.parseInt(s.nextLine());
        }
 
 
//initialize vars
        int dividedNum = num;
        int divisor = 2;
        int currentDivisorTimes = 0;
        int mostCommonFactor = 0;
        int highestDivisorTimes = 0;
 
        //start prime factorization statement, adding as factors are found
        System.out.printf("%n18 = 1");
        //check relevant numbers 
        while (divisor <= num) {
            //check for divisibility
            while (dividedNum % divisor == 0){
                //divide a clone of num for calculations, keeping num safe
                dividedNum = dividedNum / divisor ;
                //for frequency statement
                currentDivisorTimes++;
                System.out.printf(" * %d", divisor);
 
                //update frequencies/greatests
                if (currentDivisorTimes >= highestDivisorTimes){
                    mostCommonFactor = divisor;
                    highestDivisorTimes = currentDivisorTimes;
                }
            }
            currentDivisorTimes = 0;
            divisor++;
        }
 
        //depends on input type
        if (mostCommonFactor == num){
            System.out.printf("%n%d is prime.", num);
        }
        else {
            System.out.printf("%nMost common factor of %d is %d, which occurred %d times.", num, mostCommonFactor, highestDivisorTimes);
        }
    }
}