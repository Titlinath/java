//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        if (n == 1) {
            return 10;
        }
        int[][] moves = {
            {0, 8},       // Moves for 0
            {1, 2, 4},    // Moves for 1
            {2, 1, 3, 5}, // Moves for 2
            {3, 2, 6},    // Moves for 3
            {4, 1, 5, 7}, // Moves for 4
            {5, 2, 4, 6, 8}, // Moves for 5
            {6, 3, 5, 9}, // Moves for 6
            {7, 4, 8},    // Moves for 7
            {8, 5, 7, 9, 0}, // Moves for 8
            {9, 6, 8}     // Moves for 9
        };
        long[][] dp = new long[n + 1][10];
        for (int digit = 0; digit < 10; digit++) {
            dp[1][digit] = 1;
        }
         for (int length = 2; length <= n; length++) {
            for (int digit = 0; digit < 10; digit++) {
                dp[length][digit] = 0;
                for (int move : moves[digit]) {
                    dp[length][digit] += dp[length - 1][move];
                }
            }
        }
        long totalSequences = 0;
        for (int digit = 0; digit < 10; digit++) {
            totalSequences += dp[n][digit];
        }

        return totalSequences;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCount(1));  
        System.out.println(solution.getCount(2));
    }
}