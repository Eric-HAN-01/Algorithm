import java.util.*;

class Solution { 
    //dfs
    private int answer = Integer.MAX_VALUE;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(String current, String target, String[] words, int depth) {
        if (current.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && diffCount(current, words[i]) == 1) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    private int diffCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}