class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = n; i >= 0; i -= 2) {
            answer += (n % 2 == 0) ? (i*i) : i;
        }

        return answer;
    }
}

/*class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n%2 == 0) {
            for(int i=0; i<=n; i+=2) {
                answer += (i*i);
            }
        } 
        else if(n%2 == 1) {
            for(int i=1; i<=n; i+=2) {
                answer += i;
            }
        }
        return answer;
    }
}
*/