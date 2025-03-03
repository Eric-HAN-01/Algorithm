
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count = 0;
    static int[][] arr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = arr[b][a] = 1;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int j = 0; j < N; j++) {
                if(arr[cur][j] == 1 && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }

    }
}
