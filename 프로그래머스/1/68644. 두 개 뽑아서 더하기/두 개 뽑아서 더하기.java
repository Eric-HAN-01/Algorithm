import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> list = new HashSet<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list1 = new ArrayList<Integer>(list);
        Collections.sort(list1);

        System.out.println(list1);
        return list1.stream().mapToInt(i -> i).toArray();
    }
}