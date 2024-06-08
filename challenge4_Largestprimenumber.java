import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class challenge4_Largestprimenumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(largestPrimeFactor(n));
        }
        in.close();
    }
     private static long largestPrimeFactor(long n) {
        long maxPrime = -1;
        while (n % 2 == 0) {
            maxPrime = 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n /= i;
            }
        }
        if (n > 2) {
            maxPrime = n;
        }
        
        return maxPrime;
    }
}

challenge3_Largestprimenumber.java