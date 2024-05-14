import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine(); // Read the entire line
        int start = in.nextInt();
        int end = in.nextInt(); // No need to add 1 here
        
        // Remove debugging print statements
        // System.out.println("Input string: " + S);
        // System.out.println("Start index: " + start);
        // System.out.println("End index: " + end);
        
        if (start < 0 || end > S.length() || start >= end) {
            System.out.println("Invalid input");
            return;
        }
        
        String sub = S.substring(start, end); 
        
        System.out.println(sub); // Output only the substring
    }
}
