//view for git
import java.util.*;

public class Lab6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num;
        int numCopy;
        int sum = 0 ;
        for (int i=0; i < 5; i++) {
            System.out.print("Enter a number that is >10: ");
            num = Integer.parseInt(s.nextLine());

            if (num <= 10) {
                System.out.printf("Error: num is not >10%n", num);
                continue;
            }
            else {
                sum += num;
            }
            for (numCopy = num; numCopy >= 1; numCopy--){
                if (numCopy % 2 == 1) {
                    System.out.print(numCopy);
                    System.out.println("");
                }
            }
            numCopy = 0;
        }
        System.out.printf("The sum of the 5 numbers entered that are >10 is: %d.", sum);
    }
}
//view for git