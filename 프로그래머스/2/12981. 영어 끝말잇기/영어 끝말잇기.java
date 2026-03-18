import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = {0,0};
        
        HashSet<String> setword = new HashSet<>();
        
        for(int i = 0; i < words.length; i++){
            if(i != 0){
                String w1 = words[i - 1];
                String w2 = words[i];
                
                char lastword = w1.charAt(w1.length() - 1);
                char firstword = w2.charAt(0);
            
                if(setword.contains(words[i]) || lastword != firstword){
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    return answer;
                }
            }
            setword.add(words[i]);
        }
        
        return answer;
    }
}
