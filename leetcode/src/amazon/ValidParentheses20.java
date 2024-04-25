package amazon;

import java.util.Stack;

public class ValidParentheses20 {
	
	public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
                continue;
            }
            if (st.isEmpty()) {
                return false;
            }
            if (c == ')' && st.peek() != '(') {
                return false;
            }
            if (c == ']' && st.peek() != '[') {
                return false;
            }
            if (c == '}' && st.peek() != '{') {
                return false;
            }
            st.pop();
        }
        return st.isEmpty();
    }
	

	public static void main(String[] args) {
		System.out.println(new ValidParentheses20().isValid("()[]{}"));

	}

}
