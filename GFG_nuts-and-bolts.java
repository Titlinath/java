import java.io.*;
import java.util.*;

public class Solution {

    // Function to calculate the number of divisors of a number
    public static int countDivisors(int n) {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++; // Perfect square
                } else {
                    count += 2; // i and n/i
                }
            }
        }
        return count;
    }

    public static int[] precomputeResults(int maxN) {
        int[] results = new int[maxN + 1];
        int triangleNumber = 0;
        int i = 1;

        // Helper to check if there are still zeros in the results array
        boolean hasZero = true;

        // Iterate until we have found the first triangle number for every N from 1 to maxN
        while (hasZero) {
            triangleNumber += i;
            int divisors = countDivisors(triangleNumber);
            if (divisors <= maxN && results[divisors] == 0) {
                results[divisors] = triangleNumber;
            }
            i++;

            // Check if there are any remaining zeros in the results array
            hasZero = false;
            for (int n = 1; n <= maxN; n++) {
                if (results[n] == 0) {
                    hasZero = true;
                    break;
                }
            }
        }

        // Fill any remaining zeros in the results array with the first found value for higher N
        for (int n = 1; n <= maxN; n++) {
            if (results[n] == 0) {
                results[n] = results[n - 1];
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] queries = new int[T];
        int maxN = 0;

        for (int t = 0; t < T; t++) {
            queries[t] = scanner.nextInt();
            if (queries[t] > maxN) {
                maxN = queries[t];
            }
        }

        // Precompute results for all possible N values up to the maximum N in the queries
        int[] precomputedResults = precomputeResults(maxN);

        // Output the results for each query
        for (int t = 0; t < T; t++) {
            System.out.println(precomputedResults[queries[t]]);
        }

        scanner.close();
    }
}
// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
         // Define the order of the characters
        String order = "!#$%&*?@^";

        // Create a HashMap to store the order of each character
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        // Create a comparator based on the order defined above
        Comparator<Character> comparator = new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return orderMap.get(c1) - orderMap.get(c2);
            }
        };

        // Convert nuts and bolts arrays to Character arrays to use with Arrays.sort
        Character[] nutsArray = new Character[n];
        Character[] boltsArray = new Character[n];

        for (int i = 0; i < n; i++) {
            nutsArray[i] = nuts[i];
            boltsArray[i] = bolts[i];
        }

        // Sort the nuts and bolts arrays using the custom comparator
        Arrays.sort(nutsArray, comparator);
        Arrays.sort(boltsArray, comparator);

        // Copy the sorted arrays back to the original char arrays
        for (int i = 0; i < n; i++) {
            nuts[i] = nutsArray[i];
            bolts[i] = boltsArray[i];
        }
    }
}