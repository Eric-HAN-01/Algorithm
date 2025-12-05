import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> id = new HashMap<>();
        for(String s : record){
            String res[] = s.split(" ");
            
            if(res.length == 3){
                id.put(res[1], res[2]);
            }
        }
        
        
        HashMap<String, String> ans = new HashMap<>();
        ans.put("Enter", "님이 들어왔습니다.");
        ans.put("Leave", "님이 나갔습니다.");
        
        ArrayList<String> list = new ArrayList<>();
        for(String s : record){
            String res[] = s.split(" ");
            
            if(ans.containsKey(res[0])){
                list.add(id.get(res[1]) + ans.get(res[0]));
            }
        }
        
        return list.toArray(new String[0]);
    }
}