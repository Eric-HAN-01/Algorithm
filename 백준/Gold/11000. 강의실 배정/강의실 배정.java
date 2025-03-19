
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [][]class_time = new int[n][2];

        StringTokenizer st = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            class_time[i][0] = Integer.parseInt(st.nextToken());
            class_time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(class_time, new Comparator<int[]>() {

            @Override
            public int compare(int []o1, int []o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int start = class_time[i][0];
            int end = class_time[i][1];

            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            pq.add(end);

        }
        System.out.println(pq.size());

    }

}
