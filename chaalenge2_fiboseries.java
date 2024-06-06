import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class challenge2_Fiboseries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
             System.out.println(sumEvenFibonacci(n));
        }
    }
    private static long sumEvenFibonacci(long n) {
        long a = 1;
        long b = 2;
        long sum = 0;

        while (b <= n) {
            if (b % 2 == 0) {
                sum += b;
            }
            long next = a + b;
            a = b;
            b = next;
        }

        return sum;
    }
}

challenge2_Fiboseries.java