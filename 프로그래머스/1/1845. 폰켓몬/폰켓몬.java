import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int take = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        if(set.size() >= take){
            return take;
        } 
        else{
            return set.size();
        }
    }
}