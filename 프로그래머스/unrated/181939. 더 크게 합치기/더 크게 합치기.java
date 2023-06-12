class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ac = String.valueOf(a);
        String bc = String.valueOf(b);
        int ab = Integer.parseInt(ac+bc);
        int ba = Integer.parseInt(bc+ac);
        if(ab > ba) answer = Integer.parseInt(ac+bc);
        else answer = Integer.parseInt(bc+ac);

        return answer;
    }
}