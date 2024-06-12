    import java.io.*;
    import java.util.*;
    import java.text.*;
    import java.math.*;
    import java.util.regex.*;
    
    public class challenge13_Largesum {
    
    
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < N; i++) {
                String numberStr = scanner.next();
                BigInteger number = new BigInteger(numberStr);
                sum = sum.add(number);
            }
            String sumStr = sum.toString();
            System.out.println(sumStr.substring(0, Math.min(10, sumStr.length())));
        }
    }
