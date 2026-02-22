import java.util.*;

public class Lab8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //build original array
        System.out.print("Enter number of rows: ");
        int rows = Integer.parseInt(s.nextLine());
        System.out.print("Enter number of columns: ");
        int columns = Integer.parseInt(s.nextLine());
        //2d array
        //type[][] name = new type[x][y];
        int[][] arr = new int[rows][columns];
        int val = 1;
        for (int i = 0; i < arr.length; i++) {
            //loop through columns of row, 
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] += val;
                val += 1;
            }
        }

        //print original array
        for (int i = 0; i < arr.length; i++) {
            //loop through columns of row, 
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        
        //outer loop for menu

        System.out.print("Press 'a' to left-shift rows, or press 'q' to quit: ");
        String line = s.nextLine();
        char shift = line.charAt(0);

        while (shift == 'a'){
            //shift rows
            int last = 0; 
            int switched = 0;
            int swapper = 0;
                //loop through rows, (i)
            for (int i = 0; i < arr.length; i++) {
                //loop through columns of row,
                last = arr[i][0];
                
                    for (int j = 0; j < arr[i].length; j++) {
                        if (j != arr[i].length-1) {
                            switched = arr[i][(j+1)];
                            arr[i][j] = switched;
                        }
                        else {
                            arr[i][j] = last;
                        }
                    }
            }

            //print new arr
            System.out.println("Updated array: ");
            for (int i = 0; i < arr.length; i++) {
                //loop through columns of row, 
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.print("Press 'a' to left-shift rows, or press 'q' to quit: ");
            line = s.nextLine();
            shift = line.charAt(0);
            System.out.println();

            }
    }
}