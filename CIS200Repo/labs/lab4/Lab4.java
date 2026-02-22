import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //grab values

        System.out.print("Enter initial odometer mileage: ");
        double initialOdometerMileage = s.nextDouble();

        System.out.printf("Enter number of readings: ");
        int numberOfReadings = s.nextInt();


        double pastOdometerMileage = initialOdometerMileage;
        double lastOdometerMileage = initialOdometerMileage;

        
        //declare variables
        double gallonsPurchased = 0;
        //double milesDriven;
        //double fuelEconomy = 0;
        //double overallFuelEconomy = 0.0;

        int i=1;
        while (i <= numberOfReadings){
            s.nextLine();
            System.out.printf("Enter odometer reading #%d: ", i);
            double iOdometerMileage = s.nextDouble();

            System.out.print("Enter gallons of gas purchased: ");
            double gallons = s.nextDouble();

            double milesDriven = iOdometerMileage - pastOdometerMileage ;
           
            double fuelEconomy = milesDriven / gallons;

            System.out.printf("Fuel economy from reading #%d: %.2f mpg %n %n", i, fuelEconomy);
            gallonsPurchased += gallons;

            pastOdometerMileage = iOdometerMileage;
            lastOdometerMileage = iOdometerMileage;
            
            i++;
        }

        //give overall result
        double overallFuelEconomy = (lastOdometerMileage - initialOdometerMileage) / gallonsPurchased  ;
        System.out.printf("Overall fuel economy: %.2f mpg", overallFuelEconomy);
    }
}
