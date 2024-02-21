import java.util.*;
import java.io.*;

class vf{
    static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    static int countVowels(String str, int index) {
        if (index >= str.length()) {
            return 0;
        }
        int count = isVowel(str.charAt(index)) ? 1 : 0;
        return count + countVowels(str, index + 1);
    }
    public static void main(String[] args)throws IOException
    {
       // Scanner scanner = new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a sentence: ");
        String sentence = br.readLine();
        int vowelFrequency = countVowels(sentence, 0);
        System.out.println("Frequency of vowels in the sentence: " + vowelFrequency);
    }
}
