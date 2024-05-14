import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            L.add(scan.nextInt());
        }
        int Q = scan.nextInt();
        for (int i = 0; i < Q; i++) {
            String operation = scan.next();
            if (operation.equals("Insert")) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                L.add(x, y);
            } else if (operation.equals("Delete")) {
                int x = scan.nextInt();
                L.remove(x);
            }
        }
        for (int num : L) {
            System.out.print(num + " ");
        }
        scan.close();
    }
}
