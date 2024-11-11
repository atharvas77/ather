import java.util.*;

public class Nqueens 
{
    public static void PrintBoard(char board[][]) 
    {
        System.out.println("------------- Chess Board -------------");
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++) 
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); 
    }

    public static boolean isSafe(char board[][], int row, int col)
    {
        // Check vertical column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row) {
        // If all queens are placed
        if (row == board.length) {
            PrintBoard(board); 
            return;
        }

      
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place the queen
                nQueens(board, row + 1); // Recur to place the next queen
                board[row][j] = '-'; // Backtrack: Remove the queen
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total queens to be placed on the board:");
        int n = sc.nextInt();


        char board[][] = new char[n][n];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }

        // Place the first queen at (0, 0)
        board[0][0] = 'Q'; 

        nQueens(board, 0); 

        sc.close(); 
    }
}
