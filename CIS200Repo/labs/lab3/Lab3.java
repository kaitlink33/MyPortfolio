import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //declare vars
        double pizzaPrice = 12.99;
        double subtotal = 0;
        double tipRate = .20;
        double taxRate = .095;
        double tip = 0;
        double tax = 0;
        double total = 0;

        // grab user input
        System.out.print("Enter number of pizzas (0-10): ");
        int pizzasOrdered = s.nextInt();
        int dealAppliedCount = pizzasOrdered / 5 ;
        if (pizzasOrdered < 0 || pizzasOrdered > 10) {
            System.out.println("Error: number of pizzas must be 0-10");
        }
        else {
            if (pizzasOrdered % 5 == 0){
                subtotal += ((dealAppliedCount * 9.99)+((dealAppliedCount * 4) * 12.99));
                //tip
                tip = tipRate * subtotal;
                //tax
                tax = taxRate * subtotal;
                //total
                total = subtotal + tax + tip;
            }
            else {
            
                subtotal += ((dealAppliedCount * 9.99)+((dealAppliedCount * 4) * 12.99) + (12.99 *(pizzasOrdered % 5)));
                //tip
                tip = tipRate * subtotal;
                //tax
                tax = taxRate * subtotal;
                //total
                total = subtotal + tax + tip;


                
            }        //send out resulting values
        System.out.println("");
        System.out.printf("Pre-tax Total: $%.2f%n", subtotal);
        System.out.printf("Tip amount: $%.2f%n", tip);
        System.out.printf("Overall total, including tax and tip: $%.2f", total);

        }
    }
}
