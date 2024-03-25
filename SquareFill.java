import java.util.Scanner;

public class SquareFill {
    public static void main(String[] args) {
        int n, i, j;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the square:");
        n = scan.nextInt();
        char[][] square = new char[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                square[i][j] = '*';
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}