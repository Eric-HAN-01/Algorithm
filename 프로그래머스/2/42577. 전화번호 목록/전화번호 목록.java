import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Boolean> map = new HashMap<>();
        
        for(String num : phone_book){
            map.put(num, true);
        }
        
        for(String num : phone_book){
            for(int i = 1; i < num.length(); i++){
                if (map.containsKey(num.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}