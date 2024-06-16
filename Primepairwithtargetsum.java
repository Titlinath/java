import java.util.ArrayList;

public class Primepairwithtargetsum {
    public static ArrayList<Integer> getPrimes(int n) {
        // Step 1: Generate all primes up to n using the Sieve of Eratosthenes
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Step 2: Find the pair of primes (a, b) such that a + b = n
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(i);
                result.add(n - i);
                return result;
            }
        }
        
        // Step 3: If no such pair is found, return [-1, -1]
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        return result;
    }
}

