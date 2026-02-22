//adding to make visible for commit
import java.util.*;

/**
 * Driving time calculator based on distance, speed factor, round trip, and daily driving hours
 * 
 *
 * @author Kate Kendig
 * @version Proj 2
 */

public class Proj2{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //get variable inputs
        System.out.print("Enter the distance in miles: ");
        int milesToTravel = s.nextInt();

        System.out.print("Enter your speed factor, where 0 is the slowest and 9 is the fastest: ");
        int speedFactor = s.nextInt();
        s.nextLine();
        if (speedFactor < 0 || speedFactor > 9) {
            System.out.println("Speed factor must be between 0 and 9.");
            if (speedFactor < 0){
                System.out.println("The speed factor should not be negative");
            }
            else{
                System.out.println("The speed factor should not be greater than 9.");
            }
            return;
        }
        else{
            System.out.print("Are you traveling round trip? (y/n) ");
            String roundTrip = s.nextLine();

            System.out.print("Enter max driving hours per day: ");
            int dailyDrivingHours = s.nextInt();

            //calculations w inputs
            double speedTravelledMPH = (55.00 + (25.00 * ((double)speedFactor / 10.00 ))) ;
        
            if (roundTrip.equals("y")) {
                milesToTravel = (milesToTravel * 2);
            }

            //time conversion & calculation
            double speedTravelledMPS = (speedTravelledMPH * 0.00027778);
            int totalSecondsDriven = (int)(milesToTravel / speedTravelledMPS);

            //time formatting
            int secondsDailyDriven = (dailyDrivingHours * 3600);
            int days = ( totalSecondsDriven / secondsDailyDriven);
            int secondsRemainingAfterDays = totalSecondsDriven - (days * secondsDailyDriven);
            int hours = (secondsRemainingAfterDays / 3600);
            int secondsRemainingAfterHours = secondsRemainingAfterDays - (hours * 3600);
            int minutes = (secondsRemainingAfterHours / 60);
            int secondsRemainingAfterMinutes = secondsRemainingAfterHours - (minutes * 60);
            int seconds = secondsRemainingAfterMinutes;

            //returns
            System.out.printf("Total driving time for %d miles at %.2f mph: %d days, %d hours, %d minutes, %d seconds", milesToTravel, speedTravelledMPH, days, hours, minutes, seconds);
        }
    }
}
//adding to make visible for commit
