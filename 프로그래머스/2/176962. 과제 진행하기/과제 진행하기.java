import java.util.*;

class Solution {
    
    class Study {
        String name;
        int remainTime;
        
        Study(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
    
    private int convert(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<Study> works = new ArrayDeque<>();
        
        Arrays.sort(plans, (p1, p2) -> Integer.compare(convert(p1[1]), convert(p2[1])));
        
        for (int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int startTime = convert(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            int nextStartTime = convert(plans[i + 1][1]);
            int remainTime = startTime + playTime - nextStartTime;
            if (remainTime > 0) works.addLast(new Study(name, remainTime));
            else {
                answer.add(name);
                while (!works.isEmpty() && remainTime != 0) {
                    Study remainStudy = works.pollLast();
                    if (remainTime + remainStudy.remainTime > 0) {
                        works.addLast(new Study(remainStudy.name, remainTime + remainStudy.remainTime));
                        break;
                    } else {
                        remainTime += remainStudy.remainTime;
                        answer.add(remainStudy.name);
                    }
                }
            }
        }
        answer.add(plans[plans.length - 1][0]);
        
        while (!works.isEmpty()) {
            answer.add(works.pollLast().name);
        }
        return answer.toArray(new String[0]);
    }
}