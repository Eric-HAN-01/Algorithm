import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] succes = new int[N + 1];
        int[] fail = new int[N + 1];
        
        for(int i = 0; i < stages.length; i++){
            for(int j = 0; j < stages[i]; j++){
                succes[j]++;
            }
            fail[stages[i] - 1]++ ;
        }
        
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            double rate = (succes[i] == 0) ? 0.0 : (double) fail[i] / succes[i];
            map.put(i + 1, rate);  
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return keySet.stream().mapToInt(i -> i).toArray();
    }
}