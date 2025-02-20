
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int computer, n;
    static int [][] arr;
    static boolean [] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine()); // 컴퓨터 수
        n = Integer.parseInt(br.readLine()); // 간선 수

        arr = new int[computer+1][computer+1];
        visited = new boolean[computer+1];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(count-1);
    }

    public static void dfs(int i) {
        visited[i] = true;
        count++;
        for (int j = 1; j <= computer; j++) {
            if (arr[i][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }

    }
}
