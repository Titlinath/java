import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        int i, j, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        n = sc.nextInt();

        for (i = 1; i <= n; ++i) {
            for (j = 1; j <= i; ++j) {
                System.out.print(" ");
            }
            for (int l = 1; l <= j; l++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close(); 
    }
}
