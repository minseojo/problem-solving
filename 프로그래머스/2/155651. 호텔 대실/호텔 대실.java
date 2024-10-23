import java.util.*;

class Solution {
    
    class Time {
        int time;
        boolean in;
        Time(int time, boolean in) {
            this.time = time;
            this.in = in;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Time> times = new ArrayList<>();
        for (String[] b : book_time) {
            int startTime = calTimeStringToInt(b[0]);
            int endTime = calTimeStringToInt(b[1]) + 10;
            times.add(new Time(startTime, true));
            times.add(new Time(endTime, false));
        }
        
            times.sort((t1, t2) -> {
            if (t1.time != t2.time) {
                return Integer.compare(t1.time, t2.time);
            }
            return Boolean.compare(t1.in, t2.in);
        });
        int count = 0;
        for (Time t :times) {
            if (t.in) count++;
            else count--;
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    int calTimeStringToInt(String s) {
        String[] c = s.split(":");
        return Integer.parseInt(c[0]) * 60 + Integer.parseInt(c[1]);
    }
}