/**
 * calculates statistics on temperature readings
 *
 * @author Kaitlin Kendig
 * @version Project 4
 */

import java.util.*;

public class Proj4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //days in each month
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        //start date
        System.out.print("Enter starting date (m/d/y): ");
        String start = s.nextLine();
        String[] pieces = start.split("/");

        //simple error check, good if 3 parts (month, day, year) avoid dashes or dots.
        if (pieces.length != 3) {
            System.out.println("Bad start date: please use the format m/d/y.");
            return;
        }

        int[] startDate = new int[pieces.length];
        for(int i = 0; i < pieces.length; i++) {
            startDate[i] = Integer.parseInt(pieces[i]);
        }// "12/28/25", then startDate would be {12, 28, 25} 
        //make able to work with later
        int startMonth = startDate[0];
        int startDay = startDate[1];
        int startYear = startDate[2];

        //validation & working with the date started from
            //error handle month
        if (startMonth < 1 || startMonth > 12) {
            System.out.println("Bad start date: the month must be between 1 and 12.");
            return;
        }
            //positive year
        if (startYear <= 0) {
            System.out.println("Bad start date: year must be positive.");
            return;
        }
            //is leap year?
        if ((startYear % 4 == 0 && startYear % 100 != 0) || (startYear % 400 == 0)) daysInMonth[1] = 29;
            //error handle, validation check if day exists
        int totalDaysInMonth = daysInMonth[startMonth-1];
        if (startDay < 1 || startDay > totalDaysInMonth) {
            System.out.println("Bad start date: " + startDay + " does not exist in the month of " + startMonth + ".");
            return;
        }


        //time span

        System.out.print("Enter time span in days: ");
        int span = Integer.parseInt(s.nextLine());
            //arr length w span # rows w initial val from startDate
        if (span < 1) {//error handle
            System.out.println("Bad span: the time span should be at least 1 day.");
            return;
        }
        if (span > 730) {
            System.out.println("Bad span: this program does not spans exceeding 2 years.");
        }
        //new arrays fitting span length
        int[] months = new int[span];
        int[] days   = new int[span];
        int[] years  = new int[span];

        //needs filled
        months[0] = startMonth;
        days[0]   = startDay;
        years[0]  = startYear;
        for (int i = 1; i < span; i++) {
            int prevMonth = months[i - 1];
            int prevDay = days[i - 1];
            int prevYear = years[i - 1];

        daysInMonth[1] = 28;//possible year change so I am reseting, then checking
            if ( (prevYear % 4 == 0 && prevYear % 100 != 0) || (prevYear % 400 == 0) ) {
                daysInMonth[1] = 29;
            }
            
            //incrementing day
            int newDay = prevDay + 1;
            int newMonth = prevMonth;
            int newYear = prevYear;
            int maxDay = daysInMonth[prevMonth - 1];// whyd i do this? i forget
            if (newDay > maxDay) {
                // next month
                newDay = 1;
                newMonth = prevMonth + 1;
                if (newMonth > 12) {
                    //next year
                    newMonth = 1;
                    newYear = prevYear + 1;
                }
            }
            
            months[i] = newMonth;
            days[i]   = newDay;
            years[i]  = newYear;
        }//finished filling
        

        //grab high / low temps
            //dates for printf statements
        String firstDateStr = months[0] + "/" + days[0] + "/" + years[0];
        String lastDateStr = months[span-1] + "/" + days[span-1] + "/" + years[span-1];

        int[] lows = new int[span];
        System.out.printf("Enter low temperature readings from %s to %s, separated by spaces: ", firstDateStr, lastDateStr);
        for (int i = 0; i < span; i++) {
            lows[i] = s.nextInt();
        }

        int[] highs = new int[span];
        System.out.printf("Enter high temperature readings from %s to %s, separated by spaces: ", firstDateStr, lastDateStr);
        for (int i = 0; i < span; i++) {
            highs[i] = s.nextInt();
        }

//final returns
        System.out.printf("%nSummary: %n");
        for (int i = 0; i < span; i++) {
            System.out.println(months[i] + "/" + days[i] + "/" + years[i] + ". High: " + highs[i] + " degrees, low: " + lows[i] + " degrees.");
        }

        //find largest range info +  smallest range info & return
            //initialize highest
        String rangeHighestDate = months[0] + "/" + days[0] + "/" + years[0];
        int rangeHighestDateLow = lows[0]; 
        int rangeHighestDateHigh = highs[0];
        int rangeHighest = highs[0] - lows[0];
            //initialize smallest
        String rangeSmallestDate = months[0] + "/" + days[0] + "/" + years[0];
        int rangeSmallestDateLow = lows[0];
        int rangeSmallestDateHigh = highs[0];
        int rangeSmallest = highs[0] - lows[0];

        int rangei = 0;
        for (int i = 1; i < span; i++) {
            rangei = highs[i] - lows[i];
            if (rangei > rangeHighest) {
                rangeHighestDate = months[i] + "/" + days[i] + "/" + years[i];
                rangeHighest = rangei;
                rangeHighestDateLow = lows[i]; 
                rangeHighestDateHigh = highs[i];
            }
            if (rangei < rangeSmallest) {
                rangeSmallestDate = months[i] + "/" + days[i] + "/" + years[i];
                rangeSmallest = rangei;
                rangeSmallestDateLow = lows[i]; 
                rangeSmallestDateHigh = highs[i];
            }
        }
        System.out.printf("%nDate with the biggest temperature range: %s, from %d to %d degrees (range of %d degrees)", rangeHighestDate, rangeHighestDateLow, rangeHighestDateHigh, rangeHighest);
        System.out.printf("%nDate with the smallest temperature range: %s, from %d to %d degrees (range of %d degrees)", rangeSmallestDate, rangeSmallestDateLow, rangeSmallestDateHigh, rangeSmallest);
        
        //swing 
            //initialize swing variables
        int swingAmount = -1;  // track largest swing, will always be greater than here
        String previousDate = " ";
        String currDate = " ";
        int previousTemp = 0;
        int currTemp = 0;

        for (int i = 1; i < span; i++) {
            // lowest low between the two days, from intialized to 0 start. Different from how I started with 0 initialized on ranges.
            int lowPair = lows[i - 1];
            if (lows[i] < lowPair) {
                lowPair = lows[i];
            }
             // highest high between the two days, ""
            int highPair = highs[i - 1];
            if (highs[i] > highPair) {
                highPair = highs[i];
            }
            //calc swing & compare
            int swing = highPair - lowPair;
            if (swing > swingAmount) {
                swingAmount = swing;
                // store the dates as strings
                previousDate = months[i - 1] + "/" + days[i - 1] + "/" + years[i - 1];
                currDate = months[i] + "/" + days[i] + "/" + years[i];
                // store the temps used in the swing
                previousTemp = lowPair;
                currTemp = highPair;
            }
        }
        System.out.printf("%nBiggest temperature swing: %d degrees, from %d degrees on %s to %d degrees on %s.", swingAmount, previousTemp, previousDate, currTemp, currDate);

    }
}
