class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] line = new int[202];
        for (int i=0; i<lines.length; i++) {
            for (int j=lines[i][0]; j<lines[i][1]; j++) {
                line[j+100]++;
            }
        }

        int sequence = 0;
        for(int i=0; i<202; i++) {
            System.out.print(line[i]);
            if(line[i] > 1) sequence++;
            else if(sequence > 0 && line[i] < 2) {
                answer += sequence;
                sequence = 0;
            }
        }
        return answer;
    }
}