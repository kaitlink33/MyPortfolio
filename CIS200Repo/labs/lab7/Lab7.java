import java.util.*;

public class Lab7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] temps = new int[10];
        System.out.print("Enter a list of up to 10 temperatures separated by spaces, terminating with a -1: ");

        int count = 0;
        for (int i = 0; i < temps.length; i++) {
            int input = s.nextInt();
            if ( input == -1) {
                break;
            }
            temps[i] = input;
            count++;
        }

        double sum = 0.0;
        int aboveCount = 0;
        System.out.printf("%nHere are the temperatures that were below freezing (32 degrees): %n");
        for (int i = 0; i < count; i++) {
            if (temps[i] < 32) {
                System.out.print(temps[i]+ " ");
            }
            else {
                sum += temps[i];
                aboveCount++;
            }
        } 

        double avg = sum / aboveCount;
       
        System.out.printf("%n%nThe average temperature at or above freezing was %.2f degrees%n", avg);
    }
}
