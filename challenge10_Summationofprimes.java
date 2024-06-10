    import java.io.*;
    import java.util.*;
    import java.text.*;
    import java.math.*;
    import java.util.regex.*;
    
    public class challenge10_Summationofprimes {
    
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            
             int MAX_N = 1000000;
            boolean[] isPrime = new boolean[MAX_N + 1];
            long[] primeSum = new long[MAX_N + 1];
            
            Arrays.fill(isPrime, true);
            isPrime[0] = false; // 0 is not a prime number
            isPrime[1] = false; // 1 is not a prime number
            
            for (int p = 2; p * p <= MAX_N; p++) {
                if (isPrime[p]) {
                    for (int multiple = p * p; multiple <= MAX_N; multiple += p) {
                        isPrime[multiple] = false;
                    }
                }
            }
            
             for (int i = 1; i <= MAX_N; i++) {
                if (isPrime[i]) {
                    primeSum[i] = primeSum[i - 1] + i;
                } else {
                    primeSum[i] = primeSum[i - 1];
                }
            }
            
            
            for(int a0 = 0; a0 < t; a0++){
                int n = in.nextInt();
                System.out.println(primeSum[n]);
            }
            
            in.close();
        }
    }



