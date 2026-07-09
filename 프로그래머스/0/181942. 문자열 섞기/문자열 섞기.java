class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        
        for(int i = 0; i < str1.length(); i++){
            sb.append(char1[i]);
            sb.append(char2[i]);
        }
        
        return sb.toString();
    }
}