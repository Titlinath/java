import java.util.Scanner;

public class ReverseLeft{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        sc.close();

        for (int i = n; i >= 1; --i) {
            
            for (int k = 1; k <= n - i; ++k) {
                System.out.print(" ");
            }
        
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
