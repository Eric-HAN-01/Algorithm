import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, count = 0;
    static int[][][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int [] dx = {-1, 1, 0, 0, 0, 0};
    static int [] dy = {0, 0, -1, 1, 0, 0};
    static int [] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.add(new int[]{i, j, k});
                    }

                }
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        while(!q.isEmpty()){
            int [] cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int z = cur[0] + dx[i];
                int x = cur[1] + dy[i];
                int y = cur[2] + dz[i];

                if(x >= 0 && y >= 0 && z >= 0 && z < H && x < N && y < M && map[z][x][y] == 0) {
                    q.add(new int[]{z, x, y});
                    map[z][x][y] = map[cur[0]][cur[1]][cur[2]] + 1;

                }

            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0){
                        return -1;
                    }
                    count = Math.max(count, map[i][j][k]);
                }
            }
        }

        return count -1;


    }
}
