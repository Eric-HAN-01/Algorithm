
import java.util.*;
import java.io.*;


public class Main {
    static Queue<Node> q = new LinkedList<>();
    static int M, N, K, now_x, now_y;
    static int[][]map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for( int i = 0; i < T; i++ ){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int count = 0;

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(map[j][k] == 1 && !visited[j][k]){
                        count++;
                        bfs(k,j);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

    } // void main

    public static void bfs(int x, int y){
        q.offer(new Node(x, y));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int j = 0; j < 4; j++) {
                now_x = cur.x + dx[j];
                now_y = cur.y + dy[j];

                if (check() && !visited[now_y][now_x] && map[now_y][now_x] == 1) {
                    q.offer(new Node(now_x, now_y));
                    visited[now_y][now_x] = true;

                }
            }
        } //while(!q.isEmpty())
    }//bfs

    /*
    public static void dfs(int x, int y){
        visited[y][x] = true;

        for(int j = 0; j < 4; j++){
            now_x = x + dx[j];
            now_y = y + dy[j];

            if(check() && !visited[now_x][now_y] && map[now_x][now_y] == 1){
                dfs(now_x, now_y);
            }
        }
    }
    */

    public static boolean check(){
        return (now_x >= 0 &&  now_y >= 0 && now_x < M && now_y < N);
    }

} // class
