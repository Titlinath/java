import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Read input from STDIN
        Scanner scanner = new Scanner(System.in);
        
        // Read the length of the array
        int n = scanner.nextInt();
        
        // Read the array elements
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Initialize a counter for negative subarrays
        int negativeSubarrayCount = 0;
        
        // Generate all possible subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                // Calculate the sum of the current subarray from start to end
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += array[k];
                }
                // Check if the sum is negative
                if (sum < 0) {
                    negativeSubarrayCount++;
                }
            }
        }
        
        // Print the number of negative subarrays
        System.out.println(negativeSubarrayCount);
    }
}