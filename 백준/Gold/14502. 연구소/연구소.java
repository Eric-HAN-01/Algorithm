

import org.w3c.dom.Node;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] map2;
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0, 0, -1, 1};
    static int maxSafeZone = 0;

    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        map2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    public static void dfs(int block){
        if(block == 3){
            bfs();
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(block+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map2[i][j] = map[i][j];
            }
        }

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map2[i][j] == 2){
                    q.add(new Point(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(map2[nx][ny] == 0){
                        map2[nx][ny] = 2;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        int safeZone = countSafeZone(map2);

        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }

    private static int countSafeZone(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
