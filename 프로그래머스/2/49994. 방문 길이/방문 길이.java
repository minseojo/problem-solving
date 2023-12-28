class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][][] maps = new int[12][12][4];
        int y = 5;
        int x = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if (c == 'U') {
                if (y - 1 < 0) continue;
                maps[--y][x][0] = 1;
            } else if (c == 'D') {
                if (y + 1 > 10) continue;
                maps[++y][x][1] = 1;
            } else if (c == 'R') {
                if (x + 1 > 10) continue;
                maps[y][++x][2] = 1;
            } else if (c == 'L') {
                if (x - 1 < 0) continue;
                maps[y][--x][3] = 1;
            }
        }
        // UDRL
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (maps[i][j][0] == 1 && maps[i + 1][j][1] == 1) answer--;
                if (maps[i][j][2] == 1 && maps[i][j - 1][3] == 1) answer--;
                for (int k = 0; k < 4; k++) {
                    if (maps[i][j][k] == 1) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}