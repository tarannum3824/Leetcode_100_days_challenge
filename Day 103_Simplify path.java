public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        String[] components = path.split("/");
        LinkedList<String> stack = new LinkedList<>();

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }

        return result.toString();
    }
}
