import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }
        
        for(int i = 0; i < seller.length; i++){
            String s = seller[i];
            int money = amount[i] * 100;
            
            while(!s.equals("-") && money > 0){
                int fee = money / 10;
                int mine = money - fee;
                
                profitMap.put(s, profitMap.get(s) + mine);
                
                money = fee;
                s = parentMap.get(s);
            }
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++){
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }
}