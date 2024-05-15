import java.util.*;
import java.io.*;

class Solution {
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();  // Consume the newline character

        // Create a HashMap to store the phone book entries
        Map<String, Integer> phoneBook = new HashMap<>();

        // Read the phone book entries
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();  // Consume the newline character
            phoneBook.put(name, phone);
        }

        // Process each query until end-of-file
        while (in.hasNext()) {
            String s = in.nextLine();
            if (phoneBook.containsKey(s)) {
                System.out.println(s + "=" + phoneBook.get(s));
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}
