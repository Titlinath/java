import java.util.Scanner;

public class Butterfly {
    public static void drawButterflyPattern(int i) {
        int j = 2 * i - 1;
        int k = 0;
        
        for (int m = 1; m <= j; m++) {
            if (m <= i) {
                j -= 2;
                k++;
            } else {
                j += 2;
                k--;
            }
            
            for (int n = 1; n <= k; n++) {
                System.out.print("*");
            }
            
            for (int o = 1; o <= j; o++) {
                System.out.print(" ");
            }
            
            for (int p = 1; p <= k; p++) {
                if (p != i) {
                    System.out.print("*");
                }
            }
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of i : ");
        i = sc.nextInt();
        sc.close();
        drawButterflyPattern(i);
    }
}
