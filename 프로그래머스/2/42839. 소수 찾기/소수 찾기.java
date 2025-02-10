
import java.util.HashSet;

public class Solution {
    private char [] arr;
    private boolean[] check;
    private HashSet<Integer> set;

    public int solution(String number) {
        arr = number.toCharArray();
        check = new boolean[number.length()];
        set = new HashSet<>();

        for(int i = 0 ; i <= arr.length; i++) {
            dfs("",0, i);  //질문: 왜 for문 돌리는지...  dfs("",0)
        }
        return set.size();
    }

    private void dfs(String str, int depth, int index) {
        if (depth == index) {  //질문: depth == check.length???
            if(str.equals("")){
                return;
            }
            int temp = Integer.parseInt(str);
            if(isPrime(temp)){
                set.add(temp);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!check[i]){
                check[i] = true;
                dfs(str + arr[i], depth + 1, index);
                check[i] = false;
            }

        }

    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}