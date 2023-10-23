class Solution {
    public boolean isValid(String s) {
          Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char openBracket = stack.pop();
                if ((c == ')' && openBracket != '(') || (c == '}' && openBracket != '{') || (c == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}