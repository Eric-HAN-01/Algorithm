
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int [] dwarf = new int [9];
    public static int [] real = new int [7]; //진짜 난쟁이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            dwarf [i] = Integer.parseInt(br.readLine());
        } //for
        dfs(0,0);
    }

    public static void dfs(int num, int count){
        if(count == 7){
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += real[i];
            } //for
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    System.out.println(real[i]);
                } //for
                return;
            } //if(sum
            return;
        } //if(count

        for (int i = num; i < 9; i++) {
            real[count] = dwarf[i];
            dfs(i + 1, count + 1);
        }
    }//

}
