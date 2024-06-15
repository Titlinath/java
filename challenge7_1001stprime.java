import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class challenge7_1001stprime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int upperLimit = 105000; 
        boolean[] isPrime = new boolean[upperLimit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; 
        for (int i = 2; i * i < upperLimit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < upperLimit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < upperLimit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(primes.get(n - 1)); 
        }
    }
}