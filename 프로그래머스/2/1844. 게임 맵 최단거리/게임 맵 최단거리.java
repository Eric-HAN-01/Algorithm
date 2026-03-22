import java.util.*;

class Solution {
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0, 0, -1, 1};
    static int [][] visited;
    static int [][] maps;

    public int solution(int[][] maps) {
        this.maps = maps;
        visited = new int[maps.length][maps[0].length];
        bfs(0,0);
        return visited[maps.length - 1][maps[0].length - 1] == 0 ? -1 : visited[maps.length - 1][maps[0].length - 1];
    }

    public void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) {
                    continue;
                }

                
                if(maps[x][y] == 1 && visited[x][y] == 0){
                    visited[x][y] = visited[cur[0]][cur[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }

        }

    }

}
