import java.util.Scanner;

public class Zigzag2 {
    public static void zigZag(int n, int[] arr) {
        // Iterate over the array from the first element to the second last element
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {  // Even index
                // For even index: ensure arr[i] < arr[i + 1]
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {  // Odd index
                // For odd index: ensure arr[i] > arr[i + 1]
                if (arr[i] < arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Transform array to zig-zag pattern
        zigZag(n, arr);
        
        // Print the transformed array
        System.out.println("The array in zig-zag pattern is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        scanner.close();
    }
}
