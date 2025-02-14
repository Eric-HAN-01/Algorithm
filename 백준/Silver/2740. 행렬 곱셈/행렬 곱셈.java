
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);


        StringTokenizer st = new StringTokenizer(br.readLine());
        //int n=sc.nextInt();
        //int m=sc.nextInt();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        //행렬 A
        int [][]matrixA = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrixA[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        //sc.nextInt();
        //int k = sc.nextInt();
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //행렬 B

        int [][]matrixB = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행렬 C
        int [][]matrixC = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for(int x = 0; x <m; x++) {
                    matrixC[i][j] += matrixA[i][x] * matrixB[x][j];
                }
            }
        }

        // 결과 행렬 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(matrixC[i][j]).append(" ");
            }
            sb.append("\n");

        }
        System.out.print(sb);

    }

}
