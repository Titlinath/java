import java.util.*;
import java.io.*;

class NumberOfPaths2 {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of rows in the matrix: ");
        int rows = Integer.parseInt(br.readLine());

        System.out.print("Enter the number of columns in the matrix: ");
        int cols = Integer.parseInt(br.readLine());

        System.out.print("Enter the number of coins: ");
        int coins = Integer.parseInt(br.readLine());

        int[][] matrix = new int[rows][cols];

       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }

       
        matrix[0][0] = coins;

               for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (i == 0 && j == 0) {
                    continue;
                }

                
                if (i > 0) {
                    matrix[i][j] += matrix[i - 1][j]; // Add paths from above cell
                }
                if (j > 0) {
                    matrix[i][j] += matrix[i][j - 1]; // Add paths from left cell
                }
            }
        }

        
        System.out.println("Number of paths with " + coins + " coins: " + matrix[rows - 1][cols - 1]);
    }
}