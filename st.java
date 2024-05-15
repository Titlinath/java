import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }
        
        sc.close();
    }
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char openBracket = stack.pop();
                
                if (!isMatchingPair(openBracket, ch)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
