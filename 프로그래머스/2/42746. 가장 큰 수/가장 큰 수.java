import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        List<String> strings = new ArrayList<>();
        for (int n : numbers) {
            strings.add(n + "");
        }
        strings.sort((i, j) -> {
            return (j + i).compareTo(i+ j);
        });
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String s : strings) {
            if (s.equals("0")) cnt++;
            sb.append(s);
        }
        if (cnt == sb.length()) return "0";
        return sb.toString();
    }
}