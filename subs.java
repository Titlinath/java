import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt() + 1; // Adjusting the end index
        
        if (start < 0 || end > S.length() || start >= end) {
            System.out.println("Invalid input");
            return;
        }
        
        String sub = S.substring(start, end - 1); // Adjusting the end index
        
        System.out.println(sub);
    }
}

