import java.io.*;
import java.util.*;
import java.math.*;

public class challenge15_Latticepath {
    // Constants for modular arithmetic
    static final int MOD = 1000000007;
    static final int MAX = 1001; // Because N and M are at most 500, N + M is at most 1000

    // Arrays to store factorials and their modular inverses
    static long[] factorial = new long[MAX];
    static long[] inverseFactorial = new long[MAX];
    
    public static void main(String[] args) {
        // Precompute factorials and their modular inverses
        precomputeFactorials();
        
        // Scanner to read input
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        int T = scanner.nextInt();
        
        // Loop through each test case
        for (int t = 0; t < T; t++) {
            // Read dimensions N and M for the current test case
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            // Compute and print the number of unique routes for the current grid
            System.out.println(computeRoutes(N, M));
        }
    }
    
    static void precomputeFactorials() {
        // Compute all factorials % MOD up to MAX-1
        factorial[0] = 1;
        for (int i = 1; i < MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        
        // Compute the modular inverse of the last factorial using Fermat's Little Theorem
        inverseFactorial[MAX - 1] = modInverse(factorial[MAX - 1], MOD);
        
        // Compute the modular inverses of all factorials % MOD up to MAX-1
        for (int i = MAX - 2; i >= 0; i--) {
            inverseFactorial[i] = inverseFactorial[i + 1] * (i + 1) % MOD;
        }
    }
    
    static long modInverse(long a, int mod) {
        // Compute the modular inverse of 'a' % 'mod' using Fermat's Little Theorem
        return power(a, mod - 2, mod);
    }
    
    static long power(long a, long b, int mod) {
        // Compute 'a' raised to the power 'b' % 'mod' using exponentiation by squaring
        long result = 1;
        while (b > 0) {
            // If 'b' is odd, multiply the result by 'a' % mod
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            // Square 'a' % mod and halve 'b'
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }
    
    static long computeRoutes(int N, int M) {
        // Compute the number of unique routes using the binomial coefficient formula
        long numerator = factorial[N + M];
        long denominator = inverseFactorial[N] * inverseFactorial[M] % MOD;
        return numerator * denominator % MOD;
    }
}
