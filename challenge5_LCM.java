import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
             System.out.println(findLCMRange(1, n));
        }
        in.close();
    }
     private static long findLCMRange(int start, int end) {
        long lcm = 1;
        for (int i = start; i <= end; i++) {
            lcm = lcm(lcm, i);
        }
        return lcm;
    }

    private static long lcm(long a, long b) {
        return (a * (b / gcd(a, b)));
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}