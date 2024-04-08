import java.util.Scanner;

public class kpattern {
	
	public static void printPattern(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int n = scanner.nextInt();
		scanner.close();
		printPattern(n);
	}
}
