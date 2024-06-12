import java.io.*;
import java.util.*;
import java.math.*;
    
    public class challenge16_Powerdigitsum {
    
        public static void main(String[] args) {
            // Create a Scanner object to read input
            Scanner scanner = new Scanner(System.in);
            
            // Read the number of test cases
            int T = scanner.nextInt();
            
            // Loop through each test case
            for (int t = 0; t < T; t++) {
                // Read the value of N for this test case
                int N = scanner.nextInt();
                
                // Calculate 2^N using BigInteger to handle large numbers
                BigInteger powerOfTwo = BigInteger.valueOf(2).pow(N);
                
                // Convert the number to a string to sum its digits
                String powerStr = powerOfTwo.toString();
                
                // Initialize the sum of digits
                int sumOfDigits = 0;
                
                // Loop through each character in the string representation of the number
                for (char digit : powerStr.toCharArray()) {
                    // Convert the character to an integer and add it to the sum
                    sumOfDigits += Character.getNumericValue(digit);
                }
                
                // Print the sum of the digits for this test case
                System.out.println(sumOfDigits);
            }
            
            // Close the scanner
            scanner.close();
     }
 }