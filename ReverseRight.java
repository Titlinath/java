import java.util.Scanner;
public class ReverseRight {
    public static void main(String[] args)  
{  
    int i, j, n;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of rows you want to print: ");
    n = sc.nextInt();

    for (i = n - 1; i >= 0; i--) {
        for (j = 0; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

}
}
