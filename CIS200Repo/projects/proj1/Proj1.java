/*
*Prints the distance from your hometown to Manhattan, KS & Allows the user to enter a year,
 and then prints the age you turned or will turn in that year
 *
 * @author Kate Kendig
 * @version 1

*/

import java.util.*;
public class Proj1 {
    public static void main(String[] args) {
        System.out.println("It is 129 miles from my hometown to Manhattan.");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = Integer.parseInt(s.nextLine());
        String age = (year - 2006)+"";
        System.out.printf("I turned %s that year.",age);
    }
}
