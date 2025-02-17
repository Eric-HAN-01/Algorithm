class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        String[] num_str2 = num_str.split("");
        
        for(int i = 0; i<num_str2.length;i ++){
            answer += Integer.parseInt(num_str2[i]);
        }
        
        return answer;
    }
}