import java.util.Scanner;
public class fibonacciseries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of terms in the Fibonacci series: ");
        int Terms=scanner.nextInt();
        int num1=0, num2=1, num3;
        System.out.print("Fibonacci Series: ");
        for (int i=0; i<Terms; i++) {
            System.out.print(num1+" ");
            num3=num1+num2;
            num1=num2;
            num2=num3;
        }
    }
}
