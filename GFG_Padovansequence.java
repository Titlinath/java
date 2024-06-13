 //{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class GFG_Padovansequence 
    
{
  public int padovanSequence(int n)
    {
        //code here.
        // Define the modulus as required by the problem
        final int MOD = 1000000007;
        
        // Base cases
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
        
        // Initialize the first three values of the Padovan sequence
        int P0 = 1, P1 = 1, P2 = 1;
        
        // Variable to store the current value of P(n)
        int current = 0;
        
        // Loop from 3 to n to calculate P(n) using the recurrence relation
        for (int i = 3; i <= n; i++) {
            current = (P0 + P1) % MOD;
            P0 = P1;
            P1 = P2;
            P2 = current;
        }
        
        // The result is stored in P2
        return P2;
    }
    
}

