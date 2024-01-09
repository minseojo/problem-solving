import java.util.*;

class Solution {
    class File {
        String head;
        String number;
        String tail;    
        
        File(String head, String number, String tail) {
            this.head = head;
            this.number= number;
            this.tail = tail;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> result = new ArrayList<>();
        for (String f : files) {
            String head = "";
            String number = "";
            String tail = "";
            int headEndIndex = 0;
            for (int i = 0; i < f.length(); i++) {
                char c = f.charAt(i);
                if (head == "" && '0'<= c && c <= '9') {
                    head = f.substring(0, i);
                    headEndIndex = i;
                }
                else if (head != "" && !('0'<= c && c <= '9')) {
                    number = f.substring(headEndIndex, i);
                    tail = f.substring(i);
                    break;
                }
                
                if (i == f.length() - 1) {
                    number = f.substring(headEndIndex);
                }
            }
            result.add(new File(head, number, tail));
        }
        
        Collections.sort(result, (file1, file2) -> {
            int headComparison = file1.head.compareToIgnoreCase(file2.head);
            if (headComparison != 0) {
                return headComparison;
            } else {
                return Integer.compare(Integer.parseInt(file1.number), Integer.parseInt(file2.number));
            }
        });


        for (int i = 0; i < result.size(); i++) {
            String head = result.get(i).head;
            String number = result.get(i).number;
            String tail = result.get(i).tail;
            answer[i] = head + number + tail;
        }
        return answer;
    }
}