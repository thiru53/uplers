package javas;

import java.util.List;
import java.util.Stack;

public class CheckBalancedParentheses {

    private static final List<Character> OPEN = List.of('{', '(', '[');
    private static final List<Character> CLOSED = List.of('}', ')', ']');
    public static void main(String[] args) {

        String[] strArr = new String[]{"[()]{}{[()()]()}" , "[(])", "{()}[]", "([{}])" };
        for(String str : strArr){
            System.out.println(str +" Is Balanced : "+isBalancedParentheses(str));
        }
    }

    private static boolean isBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i < str.length(); i++){
            char c = str.charAt(i);
            if(stack.empty() && CLOSED.contains(c)){
                return false;
            }
            if(OPEN.contains(c)){
                stack.push(c);
            } else {
                char cout = stack.peek();
                if( (c == ')' && cout == '(') || (c == '}' && cout == '{') || (c == ']' && cout == '[') ) {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
