
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visited;
    static int [] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        visited = new boolean[n];


        dfs(0);
        System.out.print(sb);
    }
    public static void dfs(int depth) {
        if (depth == m) {
            for (int num : result){
                sb.append(num).append(" ");
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            result[depth] = i + 1;
            dfs(depth + 1);
            visited[i] = false;

        }
    }
}