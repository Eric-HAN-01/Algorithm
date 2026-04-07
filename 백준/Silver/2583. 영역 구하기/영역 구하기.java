import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int state[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int count;

    public static void main(String[] args) throws IOException{
        ArrayList<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        state = new int [M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    state[y][x] = 1;
                }
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(state[i][j] == 0){
                    bfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        sb.append(result.size()).append('\n');
        for (int num : result) {
            sb.append(num).append(' ');
        }
        System.out.print(sb);

    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        state[y][x] = 1;

        count = 1;

        while(!q.isEmpty()){
            int now[] = q.poll();
            int cy = now[0];
            int cx = now[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && state[ny][nx] == 0){
                    state[ny][nx] = 1;
                    count++;
                    q.offer(new int[]{ny, nx});
                }

            }
        }
    }
}
