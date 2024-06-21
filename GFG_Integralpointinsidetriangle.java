//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to calculate gcd of two numbers
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Function to calculate the absolute value of a number
    private long abs(long x) {
        return x < 0 ? -x : x;
    }

    // Main function to calculate the number of interior lattice points
    long InternalCount(long p[], long q[], long r[]) {
        // Coordinates of points p, q, r
        long p1 = p[0], p2 = p[1];
        long q1 = q[0], q2 = q[1];
        long r1 = r[0], r2 = r[1];
        
        // Calculate the area of the triangle using determinant formula
        long area = abs(p1 * (q2 - r2) + q1 * (r2 - p2) + r1 * (p2 - q2));
        
        // Calculate the number of boundary points using gcd
        long boundaryPoints = gcd(abs(p1 - q1), abs(p2 - q2)) +
                              gcd(abs(q1 - r1), abs(q2 - r2)) +
                              gcd(abs(r1 - p1), abs(r2 - p2));
        
        // Apply Pick's Theorem to find the number of interior lattice points
        long interiorPoints = (area - boundaryPoints + 2) / 2;
        
        return interiorPoints;
    }
}
