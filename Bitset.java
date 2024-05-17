import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int M = in.nextInt();
        
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);
        
        for (int i = 0; i < M; i++) {
            String operation = in.next();
            int set1 = in.nextInt();
            int set2 = in.nextInt();
            
            switch(operation) {
                case "AND":
                    if (set1 == 1) {
                        B1.and(B2);
                    } else {
                        B2.and(B1);
                    }
                    break;
                case "OR":
                    if (set1 == 1) {
                        B1.or(B2);
                    } else {
                        B2.or(B1);
                    }
                    break;
                case "XOR":
                    if (set1 == 1) {
                        B1.xor(B2);
                    } else {
                        B2.xor(B1);
                    }
                    break;
                case "FLIP":
                    if (set1 == 1) {
                        B1.flip(set2);
                    } else {
                        B2.flip(set2);
                    }
                    break;
                case "SET":
                    if (set1 == 1) {
                        B1.set(set2);
                    } else {
                        B2.set(set2);
                    }
                    break;
            }
            
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
        
        in.close();
    }
}
