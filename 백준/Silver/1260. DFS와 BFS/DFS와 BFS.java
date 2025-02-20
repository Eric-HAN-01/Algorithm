
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int [][]arr;
    static boolean []visited;

    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];


        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }


        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

    }

    public static void dfs(int V){
        visited[V] = true;
        sb.append(V + " ");

        for(int i = 0 ; i <= N ; i++){
            if(arr[V][i] == 1 && !visited[i]){
                dfs(i);
            }
        }

    }

    public static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;

        while(!q.isEmpty()){
            V = q.poll();
            sb.append(V + " ");

            for(int i = 0 ; i <= N ; i++){
                if(arr[V][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
