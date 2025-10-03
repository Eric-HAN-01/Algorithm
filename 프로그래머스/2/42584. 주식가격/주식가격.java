import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
            answer[stack.peek()] = i - stack.pop();
            }
            
            stack.push(i);
        }
        
        for(int time : stack){
        answer[time] = prices.length - 1 - time;
        }
        
        return answer;
    }
}