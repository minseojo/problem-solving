class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int i : num_list) {
            if (num_list.length > 10) {
                answer += i;
            } else {
                if (answer == 0) {
                    answer = 1;
                }
                answer *= i;
            }
        }
        return answer;
    }
}