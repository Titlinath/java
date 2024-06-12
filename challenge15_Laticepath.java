import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class challenge15_Laticepath {
    static final int MOD = 1000000007;
    static final int MAX = 1001; // Because N and M are at most 500, N + M is at most 1000
    static long[] factorial = new long[MAX];
    static long[] inverseFactorial = new long[MAX];
    
    public static void main(String[] args) {
         precomputeFactorials();
        
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println(computeRoutes(N, M));
        }
    }
    
     static void precomputeFactorials() {
        factorial[0] = 1;
        for (int i = 1; i < MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        inverseFactorial[MAX - 1] = modInverse(factorial[MAX - 1], MOD);
        for (int i = MAX - 2; i >= 0; i--) {
            inverseFactorial[i] = inverseFactorial[i + 1] * (i + 1) % MOD;
        }
    }
    
    static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }
    
    static long power(long a, long b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }
    
    
    static long computeRoutes(int N, int M) {
        long numerator = factorial[N + M];
        long denominator = inverseFactorial[N] * inverseFactorial[M] % MOD;
        return numerator * denominator % MOD;
    }
}