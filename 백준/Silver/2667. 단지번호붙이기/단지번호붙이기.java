
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, count = 1;
	static List<Integer> result;
	static int [][]map;
	static int []dx = {-1, 1, 0 , 0};
	static int []dy = {0, 0, -1, 1};
	
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		result = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++){
				if(map[i][j] == 1) {
					bfs(i,j);
					result.add(count);
					count = 1;
				}
			}
		}
		
		Collections.sort(result);
		sb.append(result.size()).append("\n");
		for(int r : result) {
			sb.append(r).append("\n");
		}
		System.out.println(sb);


	}

	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		map[x][y] = 0;
		
		while(!q.isEmpty()) {
			int []cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
					count++;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
	}

}
