import java.util.*;

class Solution {
    //BFS
    public int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] visit = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                bfs(computers, i, visit);
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(int[][] computers, int start, boolean[] visit){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        
        while(!q.isEmpty()){
            int net = q.poll();
            
            for(int j = 0; j < computers.length; j++){
                if(computers[net][j] == 1 && !visit[j]){
                    visit[j] = true;
                    q.add(j);
                }
            }
        }
    }
    
//     //DFS
//     public int solution(int n, int[][] computers) {
//         int answer = 0;
//         boolean[] visit = new boolean[n];
        
//         for(int i = 0; i < n; i++){
//             if(!visit[i]){
//                 dfs(computers, i, visit);
//                 answer++;
//             }
//         }
//         return answer;
//     }
    
//     static private void dfs(int[][] computers, int i, boolean[] visit){
//         visit[i] = true;
        
//         for(int j = 0; j < computers.length; j++){
//             if(computers[i][j] == 1 && !visit[j]){
//                 dfs(computers, j, visit);
//             }
//         }
//     }
    
    
}