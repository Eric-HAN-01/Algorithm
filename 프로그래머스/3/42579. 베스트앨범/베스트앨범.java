import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> genreTotal = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> genreSongMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);
            
            if (!genreSongMap.containsKey(genre)) {
                genreSongMap.put(genre, new HashMap<>());
            }
            genreSongMap.get(genre).put(i, play);
        }

        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((g1, g2) -> genreTotal.get(g2) - genreTotal.get(g1));

        ArrayList<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            HashMap<Integer, Integer> songs = genreSongMap.get(genre);
            
            List<Integer> top2Songs = songs.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue().equals(b.getValue())) {
                        return a.getKey() - b.getKey();
                    }
                    return b.getValue() - a.getValue();
                })
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
            
            result.addAll(top2Songs);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}