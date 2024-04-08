import java.util.Scanner;

public class Hollow{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the triangle: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
