import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, HashSet<String>> id = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for(String s : report) {
            String[] str = s.split(" ");
	        String from = str[0];
	        String to = str[1];
            
            if (!id.containsKey(from)) {
                id.put(from, new HashSet<>());
            }
            
            if (id.get(from).add(to)) {
                count.put(to, count.getOrDefault(to, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            
            if (id.containsKey(user)) {
                for (String target : id.get(user)) {
                    if (count.getOrDefault(target, 0) >= k) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}