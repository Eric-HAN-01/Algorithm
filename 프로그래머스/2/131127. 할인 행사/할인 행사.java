import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantbuy = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            wantbuy.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 9; i++){
            HashMap<String, Integer> realbuy = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                if(wantbuy.containsKey(discount[j])){
                    realbuy.put(discount[j], realbuy.getOrDefault(discount[j] , 0) + 1);
                }
            }
            if(realbuy.equals(wantbuy)){
                answer++;
            }
        }
        
        return answer;
    }
}