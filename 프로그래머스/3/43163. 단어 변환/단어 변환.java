import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        int answer = 0;
        List<String> wordList = new ArrayList<>();
        for (String w : words) {
            wordList.add(w);
        }
        q.add(begin);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String front = q.poll();
                if (front.equals(target)) {
                    return answer;
                }
                
                List<String> tempList = new ArrayList<>();
                for (int j = 0; j < wordList.size(); j++) {
                    String w = wordList.get(j);
                    int diffCount = 0;
                    for (int i = 0; i < w.length(); i++) {
                        if (w.charAt(i) != front.charAt(i)) {
                            diffCount++;
                        }
                    }
                    if (diffCount == 1) {
                        q.add(w);
                        tempList.add(w);
                    }
                }
                
                for (String tw : tempList) {
                    for (int i = 0; i < wordList.size(); i++) {
                        if (tw.equals(wordList.get(i))) {
                            wordList.remove(tw);
                        }
                    }
                }
            }
            answer++;
        }
        
        
        return 0;
    }
}