import java.util.Scanner;
public class sumofnumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 5 numbers:");
        int[]numbers=new int[5];
        for (int i=0;i<5;i++) {
            numbers[i]=scanner.nextInt();
        }
        int sum=0;
        for (int number : numbers) {
            sum+=number;
        }
        System.out.println("Sum of the numbers:"+sum);
    }
}