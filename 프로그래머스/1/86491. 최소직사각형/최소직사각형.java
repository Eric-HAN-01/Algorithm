import java.util.Arrays;
class Solution {
    public int solution(int[][] sizes) {
        
        int maxWidth = 0; // 최대 가로
        int maxHeight = 0; // 최대 세로

        for (int[] size : sizes) { //각 배열에서 최대.최솟값 찾기
            int width = Math.max(size[0], size[1]); // 최대 가로
            int height = Math.min(size[0], size[1]); // 최소 세로
            
            maxWidth = Math.max(maxWidth, width); //최대 가로
            maxHeight = Math.max(maxHeight, height); //최소 세로
        }

        //최소 넓이 값 
        int result = maxWidth * maxHeight;

        return result;

    }
}