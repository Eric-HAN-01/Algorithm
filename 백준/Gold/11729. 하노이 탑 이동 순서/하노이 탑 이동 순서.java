
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //최소 옮긴 횟수
        sb.append((int)(Math.pow(2, N)-1)+"\n");

        hanoi(N, 1, 2, 3);
        System.out.println(sb.toString());
    }

    private static void hanoi(int N, int a, int b, int c) {
        if (N == 1){
            sb.append(a + " " + c +"\n");
            return;
        }

        // N-1개 a -> b
        hanoi(N-1, a, c, b);
        // 남은 1개 a->c
        sb.append(a + " " + c +"\n");
        // b로 옮겨진 N-1개 b->c
        hanoi(N-1, b, a, c);
    }
}
