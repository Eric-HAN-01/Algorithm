import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    private static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int a, int b) {
        q.clear();
        q.add(new int[]{a, b, 0});
        visited[a][b][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];


            if (x == N - 1 && y == M - 1) {
                return visited[x][y][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {

                    if (map[nx][ny] == 0) {
                        if (visited[nx][ny][broken] == 0) {
                            visited[nx][ny][broken] = visited[x][y][broken] + 1;
                            q.add(new int[]{nx, ny, broken});
                        }
                    }
                    //벽하나만 부수기
                    else if (map[nx][ny] == 1 && broken == 0) {
                        if (visited[nx][ny][1] == 0) {
                            visited[nx][ny][1] = visited[x][y][0] + 1;
                            q.add(new int[]{nx, ny, 1});
                        }
                    }
                }
            }
        }

        return -1; // No path found
    }
}