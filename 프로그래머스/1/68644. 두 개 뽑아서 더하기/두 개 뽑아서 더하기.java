import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] a = new int [201];
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                a[numbers[i] + numbers[j]]++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            if (a[i] > 0) result.add(i);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}