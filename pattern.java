import java.util.*;
import java.io.*;

public class pattern {
    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string:");
        s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }
    }
}