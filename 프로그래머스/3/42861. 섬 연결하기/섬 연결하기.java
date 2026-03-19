import java.util.*;
class Solution {
    static int [] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        //비용순으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if(find(a) != find(b)){
                union(a,b);
                answer += c;
            }
        }
        
        return answer;
    }
    
    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}