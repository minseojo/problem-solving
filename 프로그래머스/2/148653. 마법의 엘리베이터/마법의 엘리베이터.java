class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int n = storey % 10;
            System.out.println(n + " " + answer);
            if (n > 5) {
                answer += (10 - n);
                storey = (storey / 10) + 1;
            } else if (n == 5 && ((storey / 10) % 10 >= 5)) {
                answer += 5;
                storey = (storey / 10) + 1;
            } else {
                answer += n;
                storey /= 10;
            }
        }
        return answer;
    }
}