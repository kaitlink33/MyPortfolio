import java.util.*;
public class Lab2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of donuts needed: ");
        int donutsNeeded = s.nextInt();

        //int boxesNeeded = donutsNeeded / 12;
        int boxesNeeded = ((donutsNeeded-1)/12) + 1;
        //if (donutsNeeded % 12 != 0){
        //    int boxesNeeded = boxesNeeded + 1;
        //}

        int totalDonuts = boxesNeeded * 12;
        int unusedDonuts = totalDonuts - donutsNeeded;
        
        double subtotal = boxesNeeded * 11.99;
        double taxRate = 0.0915;
        double tax = taxRate * subtotal;
        double total = subtotal + tax;

        System.out.println("Boxes needed: " + boxesNeeded);
        System.out.println("Total donuts: " + totalDonuts + ", " + unusedDonuts + " of which aren't needed.");
        System.out.println(" ");
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax (9.15%%): $%.2f%n", tax);
        System.out.printf("Total purchase: $%.2f%n", total);
    }
}


/*
Enter number of donuts needed: 25
Boxes needed: 3
Total donuts: 36, 11 of which aren't needed

Subtotal: $35.97
Tax (9.15%): $3.29
Total purchase: $39.26
 */