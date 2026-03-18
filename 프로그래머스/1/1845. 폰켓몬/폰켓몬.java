import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> setnums= new HashSet<>();
        int count = nums.length / 2;
        
        for(int i : nums){
            setnums.add(i);
        }
        
        if(setnums.size() > count ){
            return count;
        }
        else return setnums.size();
    }
}