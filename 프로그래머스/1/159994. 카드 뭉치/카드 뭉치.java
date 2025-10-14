import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1q = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cards2q = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> goalq = new ArrayDeque<>(Arrays.asList(goal));
        
        while(!goalq.isEmpty()){
            if(!cards1q.isEmpty() && cards1q.peek().equals(goalq.peek())){
                cards1q.poll();
                goalq.poll();
            } else if(!cards2q.isEmpty() && cards2q.peek().equals(goalq.peek())){
                cards2q.poll();
                goalq.poll();
            } else {
                break;
            }
        }
        
        return goalq.isEmpty() ? "Yes" : "No";
        
    }
}