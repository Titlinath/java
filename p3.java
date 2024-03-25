import java.util.*;

public class p3 {
    public static void main(String[] args) {
        String str1 = "Titli";
        int length = str1.length();
        int halfLength = length / 2;

        // Top half of the diamond
        for (int i = 0; i < halfLength; i++) {
            System.out.println(str1.substring(0, i));
            System.out.println(str1.substring(i));
            length--;
        }

        // Middle line
        System.out.println(str1);

        // Bottom half of the diamond
        for (int i = 1; i < halfLength; i++) {
            System.out.println(str1.substring(0, length - 1));
            System.out.println(str1.substring(length - 1));
            length++;
        }
    }
}