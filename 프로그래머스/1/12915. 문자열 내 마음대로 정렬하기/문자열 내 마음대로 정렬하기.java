import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        List<String> stringsList = new ArrayList<>();
        for (String s : strings) {
            stringsList.add(s);
        }
        stringsList.sort((String i, String j) -> Integer.compare(i.charAt(n), j.charAt(n)));
        
        String[] answer = new String[strings.length];
        for (int i = 0; i < stringsList.size(); i++) {
            answer[i] = stringsList.get(i);
        }
        return answer;
    }
}