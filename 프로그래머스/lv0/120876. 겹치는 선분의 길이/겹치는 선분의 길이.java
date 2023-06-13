class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int clash = 0;
        for (int i = -100; i <= 100; i++) {
            clash = 0;
            if(lines[0][0] <= i && i < lines[0][1]) clash++;
            if(lines[1][0] <= i && i < lines[1][1]) clash++;
            if(lines[2][0] <= i && i < lines[2][1]) clash++;
            
            if(clash > 1) answer++;
        }
        return answer;
    }
}

/*
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] line = new int[202];
        for (int i=0; i<lines.length; i++) {
            for (int j=lines[i][0]; j<=lines[i][1]; j++) {
                line[j+100]++;
            }
        }
        
        int sequence = 0;
        for(int i=0; i<202; i++) {
            System.out.print(line[i]);
            if(line[i] > 1) sequence++;
            else if(sequence > 0 && line[i] < 2) {
                answer += (sequence-1);
                sequence = 0;
            }
        }
        return answer;
    }
}
*/