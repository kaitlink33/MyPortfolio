import java.util.*;

public class Example {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Hello, user!");
        
        System.out.print("Enter a number: ");
        int num = s.nextInt();
        int more = num+1;
        
        System.out.printf("One more is %d%n", more);
    }
}
