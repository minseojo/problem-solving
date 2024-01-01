import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // routes[][1]을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int curRoute = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (curRoute < route[0]) {
                curRoute = route[1];
                answer++;
            }
        }

        return answer;
    }
}
