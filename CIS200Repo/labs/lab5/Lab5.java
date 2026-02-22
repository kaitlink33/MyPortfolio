import java.util.*;

public class Lab5{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  
        Random r = new Random();

        /* In class sample:
        System.out.print("Enter dice value (1-6): ");

        int val = s.nextInt();

        do {
            //makes system pause
            System.out.print("Press Enter to roll.");
            s.nextLine();
            dice = r.nextInt(6) +1;
            System.out.print("You rolled %d%n", dice);
        } while (dice != val);
         */
        int gameTotal = 0;
        int dice;
        do {
            //makes system pause
            System.out.printf("Press Enter to roll.%n");
            s.nextLine();
            dice = r.nextInt(6) +1;
            gameTotal+= dice;

            if (dice == 1) {
                System.out.println("You rolled 1.");
                gameTotal = 0;
                System.out.printf("%nFinal score: %d points. You lose.", gameTotal);
                break;
            }
            
            if (gameTotal >= 20){
                System.out.printf("You rolled %d%n", dice);
                System.out.printf("Final score: %d points. You win!", gameTotal);
                break;
            }

            System.out.printf("You rolled %d%n", dice);
            System.out.printf("Game total: %d points%n", gameTotal);

        } while (dice != 1);
        
    }
}

