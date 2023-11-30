import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        
        String[] split = s.split("}");
        List<String> splitList = Arrays.asList(split);
        splitList.sort(Comparator.comparingInt(o -> o.length()));
        
        int[] answer = new int[splitList.size()];
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < splitList.size(); i++) {
            String tmp = splitList.get(i);
            if (tmp.charAt(0) == ',' && tmp.charAt(1) == '{') {
                tmp = tmp.substring(2);
            } else if (tmp.charAt(0) == '{') {
                tmp = tmp.substring(1);
            }
            String[] tmpSplit = tmp.split(",");


            for (String sn : tmpSplit) {
                if (!set.contains(sn)) {
                    set.add(sn);
                    answer[i] = Integer.valueOf(sn);
                    break;
                }
            }
        }
        return answer;
    }
}