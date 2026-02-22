import java.util.*;

public class Tutorial4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //type[] name = new type[size]; 


        /*
        //Example 1:
        //get 10 numbers from user, report min/max/avg
        int[] arr = {1,2,3};

        for (int i = 0; i < arr.length; i++){
            System.out.print("Enter number: ");
            arr[i] = s.nextInt();
        }

        double sum = arr[0]; 
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            sum += arr[i];

            if (arr[i] < min){
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
        
        //print stats
        double avg = sum / arr.length;
        System.out.printf("Average: %.2f%n", avg);
        System.out.printf("Minimum: %d%n", min);
        System.out.printf("Maximum: %d%n", max);
        */

        /*Example 2: play text-based Tic-Tac-Toe, with board lik:
        _ _ _
        _ _ _
        _ _ _

        */

        //create board
        char[][] board = new char [3][3];

        //board.length: # rows
        //board[i].length
        
        //outer loop through rows
            //inner loop through columns
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++){
                board[i][j]= '_';
            }
        }
            
        //print the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++){
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
        
        //current turn
        char turn = 'X';

        //has somone won?
        boolean winner = false;


        //9 potential moves
        int moves = 0;
        while (moves < 9) {
            System.out.println();
            //ask the current user for a move (row/col)
            System.out.printf("%c, enter row: ", turn);
            int row = s.nextInt();
            System.out.printf("%c, enter column: ", turn);
            int column = s.nextInt();
            System.out.println();

            //validate the user input
            if (row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] =='_') {
                //put in their place
                board[row][column] = turn;

                //print the board
                for (int i = 0; i < board.length; i++){
                    for (int j = 0; j < 3; j++) {
                        System.out.printf("%c ", board[i][j]);
                    }
                    System.out.println();
                }

                //did they win?
                for (int i = 0; i < 3; i++) {
                    //did they win on a row?
                    if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == turn) {
                        winner = true;
                    }

                    //did they win on a column?
                    if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == turn){
                        winner = true;
                    }
                }

                //did they win on a /?
                if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
                    winner = true;
                }

                //did they win on a \?
                if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
                    winner = true; 
                }

                //leave game play loop if someone won
                if (winner) break;

                //switch whose turn
                if (turn == 'X') turn = 'O';
                else turn = 'X';

                moves++;
            }
            else {
                //must have been a bad move
                System.out.println("bad move, go again.");
            } 
        }

        //did someone win? 
        if (winner) {
            System.out.printf("%c wins!%n", turn);
        }
        else {
            System.out.println("Tie game.");
        }
    }

}
