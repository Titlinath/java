import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class challenge6_sumofsquaresoffirsttennaturalnumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(calculateDifference(n));
        }
        in.close();
    }
     private static long calculateDifference(int n) {
        
        long sumOfSquares = n * (n + 1L) * (2 * n + 1L) / 6;
        
        
        long sum = n * (n + 1L) / 2;
        
      
        long squareOfSum = sum * sum;
        
       
        return squareOfSum - sumOfSquares;
    }
}
