import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(sumOfMultiples(n));
        }
    }

    private static long sumOfMultiples(int n) {
        n--;  
        return sumDivisibleBy(n, 3) + sumDivisibleBy(n, 5) - sumDivisibleBy(n, 15);
    }

    private static long sumDivisibleBy(int n, int k) {
        long p = n / k;
        return k * p * (p + 1) / 2;
    }
}
