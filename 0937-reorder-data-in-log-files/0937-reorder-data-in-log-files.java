import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        
        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        
        letterLogs.sort((s1, s2) -> {
            String[] s1Log = s1.split(" ", 2);
            String[] s2Log = s2.split(" ", 2);
            
            // 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤인 경우 -1
            int compared = s1Log[1].compareTo(s2Log[1]);
            // 로그가 동일한 경우 식별자 비교
            if (compared == 0) {
                return s1Log[0].compareTo(s2Log[0]);
            } else {
                return compared;
            }
        });
            
        letterLogs.addAll(digitLogs);
        
        return letterLogs.toArray(new String[0]);
    }
}