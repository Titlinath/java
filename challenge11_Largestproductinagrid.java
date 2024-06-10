import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class challenge11_Largestproductinagrid {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] grid = new int[20][20];

        // Reading the grid
        for (int grid_i = 0; grid_i < 20; grid_i++) {
            for (int grid_j = 0; grid_j < 20; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        int maxProduct = 0;

        // Calculating the maximum product
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                // Check horizontally to the right
                if (j + 3 < 20) {
                    int product = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }

                // Check vertically downwards
                if (i + 3 < 20) {
                    int product = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }

                // Check diagonally to the bottom right
                if (i + 3 < 20 && j + 3 < 20) {
                    int product = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }

                // Check diagonally to the bottom left
                if (i + 3 < 20 && j - 3 >= 0) {
                    int product = grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3];
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
        }

        System.out.println(maxProduct);
    }
}
