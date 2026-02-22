import java.util.*;

public class Tutorial1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Example 1: FizzBuzz 
        //get a positive integer from user
        //print "FizzBuzz" if the number is divisible by both 3 and 5
        //print "Fizz" if the number is divisible by 3 but not 5
        //print "Buzz" if the number is divisible by 5 but not 3
        //print the number itself if the number isn't divisible by either 3 or 5

        //16 - would print 16 itself
        //25 - would print "Buzz"
        //30 - would print "FizzBuzz"

        //     % - modulo or remainder


        System.out.print("Enter a positive integer: ");
        int num = s.nextInt();

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
            System.out.println("Another");
        }
        else if (num % 3 == 0) {//we know here it can't be divisible by both
            System.out.println("Fizz");
        }
        else if (num % 5 ==0) {
            System.out.println("Buzz");
        }
        else{
            System.out.println(num);
        }


        //Example 2: get 3 test scores, print the average and the letter grade.
        System.out.print("Enter first test score (0-100): ");
        int score1 = s.nextInt();
        System.out.print("Enter second test score (0-100): ");
        int score2 = s.nextInt();
        System.out.print("Enter third test score (0-100): ");
        int score3 = s.nextInt();

        //find average
        double average = (score1 + score2 + score3) / 3.0;
        System.out.printf("Average: %.2f%n",average);

        if (average >= 90.0){
            System.out.println("A");
        }
        else if (average >= 80.0){//already know avg < 90 since in else if
            System.out.println("B");
        }
        else if (average >= 70.0){
            System.out.println("C");
        }
        else if (average >= 60.0){
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }


        //Example 3: Magic 8-ball
        s.nextLine();
        System.out.print("Enter your question: ");
        String question = s.nextLine();
        

        //print one of 8 random responses
        
        Random r = new Random();

        int random = r.nextInt(8); //random will be randomly 0,1,2,3,4,5,6,7

        switch (random) {
            case 0:
                System.out.println("Definitely");
                break;
            case 1:
                System.out.println("Avoid");
                break;
            case 2:
                System.out.println("Not right now");
                break;
            case 3:
                System.out.println("Perhaps");
                break;
            case 4:
                System.out.println("Bad outlook");
                break;
            case 5:
                System.out.println("Probably");
                break;
            case 6:
                System.out.println("Definitely not");
                break;
            case 7:
                System.out.println("Sure");
                break;
        }
    }
}
