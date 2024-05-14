import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine(); // Move to the next line
        
        List<List<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> lineNumbers = new ArrayList<>();
            int d = scan.nextInt();
            for (int j = 0; j < d; j++) {
                lineNumbers.add(scan.nextInt());
            }
            numbers.add(lineNumbers);
        }
        
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (x >= 1 && x <= n && y >= 1 && y <= numbers.get(x - 1).size()) {
                System.out.println(numbers.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}
