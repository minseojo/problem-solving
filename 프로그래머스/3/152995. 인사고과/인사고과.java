import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        // 1. 점수1 기준 내림차순, 점수2 기준 오름차순 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });

        int maxB = 0;
        List<int[]> valid = new ArrayList<>();

        for (int[] score : scores) {
            if (score[1] < maxB) {
                // 두 점수 모두 작으면 탈락 (봉우리 조건)
                if (score[0] == wanho[0] && score[1] == wanho[1]) return -1;
                continue;
            }
            maxB = Math.max(maxB, score[1]);
            valid.add(score);
        }

        // 2. 유효한 사람들 대상으로 등수 계산
        valid.sort((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));

        int rank = 1;
        for (int i = 0; i < valid.size(); i++) {
            int[] score = valid.get(i);
            if (score[0] == wanho[0] && score[1] == wanho[1]) {
                return rank;
            }

            if (i < valid.size() - 1) {
                int currSum = score[0] + score[1];
                int nextSum = valid.get(i + 1)[0] + valid.get(i + 1)[1];
                if (currSum != nextSum) rank = i + 2;
            }
        }

        return -1;
    }
}
