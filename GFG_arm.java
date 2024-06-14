//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class GFG_arm {
    static String armstrongNumber(int n){
        // code here
         int originalNumber = n;
        int sum = 0;
        
        // Extracting each digit and calculating the sum of the cubes of its digits
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit * digit;
            n /= 10;
        }
        
        // Check if the calculated sum is equal to the original number
        if (sum == originalNumber) {
            return "Yes";
        } else {
            return "No";
        }
    }
}