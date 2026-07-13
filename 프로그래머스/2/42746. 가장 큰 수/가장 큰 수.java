import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // a+b, b+a를 비교해서 더 큰 쪽이 앞에 오도록 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for (String s : strNumbers) {
            sb.append(s);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}