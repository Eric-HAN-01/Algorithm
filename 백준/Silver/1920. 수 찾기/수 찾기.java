
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int []arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr =new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++ ){
            if(binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0){
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int binarySearch(int []arr, int num){
        int low = 0;
        int high = arr.length -1;


        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == num ) {
                return 0;
            } else if(arr[mid] < num){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;


    }
}
