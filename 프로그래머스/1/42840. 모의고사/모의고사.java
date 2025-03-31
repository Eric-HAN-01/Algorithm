import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int [] result = new int [3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == student1[i % student1.length]){
                result[0]++;
            }
            if(answers[i] == student2[i % student2.length]){
                result[1]++;
            }
            if(answers[i] == student3[i % student3.length]){
                result[2]++;
            }
        }
        
        int maxScore = Math.max(result[0], Math.max(result[1], result[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        
         for (int i = 0; i < 3; i++) {
            if (maxScore == result[i]) list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}