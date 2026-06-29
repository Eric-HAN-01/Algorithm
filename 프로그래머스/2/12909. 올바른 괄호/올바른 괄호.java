import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stackDeque = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if (c == '('){
                stackDeque.push(c);
            } 
            else if (c == ')') {
                if (stackDeque.isEmpty()) {
                    return false;
                }
                stackDeque.pop();
            }
        }
        
        return stackDeque.isEmpty();
    }
}