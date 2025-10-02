import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i, s.length()) + s.substring(0, i);
            stack.clear();
            
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                
                if(stack.isEmpty()){
                    stack.push(c);
                } else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                } else if(c == ')' && stack.peek() == '('){
                    stack.pop();
                } else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                result++;
            }
        }
        return result;
    }
}