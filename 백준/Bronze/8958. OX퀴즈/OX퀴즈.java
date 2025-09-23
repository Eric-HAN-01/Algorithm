import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int score;
        int sum;

        for (int i = 0; i < N; i++){
            score = 0;
            sum = 0;
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == 'O'){
                    score++;
                    sum += score;
                } 
                else {
                    score = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
