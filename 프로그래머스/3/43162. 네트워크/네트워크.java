class Solution {
    //DFS
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(computers, i, visit);
                answer++;
            }
        }
        return answer;
    }
    
    static private void dfs(int[][] computers, int i, boolean[] visit){
        visit[i] = true;
        
        for(int j = 0; j < computers.length; j++){
            if(computers[i][j] == 1 && !visit[j]){
                dfs(computers, j, visit);
            }
        }
    }
}