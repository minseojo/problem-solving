import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> height = new ArrayList<>();
        
        while (k > 1) {
            height.add(k);
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }
        height.add(1);
        
        int n = height.size() - 1;
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            if (a > b) {
                answer[i] = -1.0;
                continue;
            } 
            if (a == b) {
                answer[i] = 0.0;
                continue;
            }
            double sum = 0.0;
            for (int j = a + 1; j <= b; j++) {
                double pre = height.get(j-1);
                double cur = height.get(j);
                if (cur == pre) {
                    sum += height.get(j);
                } else if(cur > pre) {
                    sum += (pre + (cur - pre) / 2);
                } else {
                    sum += (cur + (pre - cur) / 2);
                }
            }
            answer[i] = sum;
        }
            
        return answer;
    }
}