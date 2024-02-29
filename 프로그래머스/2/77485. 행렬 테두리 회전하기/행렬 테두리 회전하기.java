import java.util.*;

class Solution {
    int[][] arr = new int[101][101];
    public int[] solution(int rows, int columns, int[][] queries) {
        int pos = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = pos++;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = findMinValue(rows, columns, queries[i]);
        }
        return answer;
    }
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    private int findMinValue(int rows, int columns, int[] query) {
        int sy = query[0];
        int sx = query[1];
        int ey = query[2];
        int ex = query[3];
        
        int cy = sy;
        int cx = sx;
        int temp = arr[sy][sx];
        int temp2 = -1;
        int result = temp;

        for (int i = 0; i < 4; i++) {
            while (true) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny < sy || nx < sx || ny > ey || nx > ex) break;
                temp2 = arr[ny][nx];
                arr[ny][nx] = temp;
                temp = temp2;
                result = Math.min(result, temp);
                cy = ny;
                cx = nx;
            }
        }
        
        return result;
    }
    
    
}