class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 3; i <= (brown + yellow); i++) {
            int length = (brown + yellow) / i;
            if((length - 2) * (i - 2) == yellow) {
                answer[0] = length;
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}