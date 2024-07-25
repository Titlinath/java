//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean kPangram(String str, int k) {
        
        int n = str.length();
        
        if(n < 26)
            return false;
        
        int count = 0;
        int countSpaces = 0;
        int[] ch = new int[26];
        
        for(int i = 0; i < n; i++){
            
            char c = str.charAt(i);
            
            if(Character.isLowerCase(c)){
                ch[c - 'a']++;
                
                if(ch[c - 'a'] == 1){
                    count++;
                }
            }
                
            else{
                countSpaces++;
            }
        }
        
        int value = n - (countSpaces + count);
        int remainLC = 26 - count;
        
        if(value >= remainLC && k >= remainLC)
            return true;
        
        return false;
    }
}
