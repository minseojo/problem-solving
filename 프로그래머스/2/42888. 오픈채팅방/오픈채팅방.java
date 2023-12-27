import java.util.*;

class Solution {
    static String ENTER_MESSAGE = "님이 들어왔습니다.";
    static String LEAVE_MESSAGE = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        int answerLength = 0;
        for (int i = 0; i < record.length; i++) {
            String tag = record[i].split(" ")[0];
            if (!tag.equals("Change")) {
                answerLength++;
            }
        }
        String[] answer = new String[answerLength];
        Map<String, String> nicknames = new HashMap<>();
        
        int curAnswerLength = 0;
        for (int i = 0; i < record.length; i++) {
            String r = record[i];
            String[] sr = r.split(" ");
            String tag = sr[0];
            String id = sr[1];
            String nickname = "";
            if (tag.equals("Enter")) {
                nickname = sr[2];
                nicknames.put(id, nickname);
                answer[curAnswerLength++] = id + ENTER_MESSAGE;
            } else if (tag.equals("Leave")) {
                answer[curAnswerLength++] = id + LEAVE_MESSAGE;
            } else if (tag.equals("Change")) {
                nickname = sr[2];
                nicknames.put(id, nickname);
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            int pos = 0;
            for (char c : answer[i].toCharArray()) {
                if (c != '님') {
                    pos++;
                } else {
                    break;
                }
            }
            String id = answer[i].substring(0, pos);
            String message = answer[i].substring(pos);
            answer[i] = nicknames.get(id) + message;
        }
        return answer;
    }
}