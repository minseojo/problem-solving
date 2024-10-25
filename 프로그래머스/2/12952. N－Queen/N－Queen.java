import java.util.Arrays;

class Solution {
    
    int answer;
    int[] row;
    public int solution(int n) {
        row = new int[n];
        Arrays.fill(row, -1);
        return dfs(0, n);
    }
    
    int dfs(int y, int n) {
        if (y == n) return 1;
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            row[y] = i;
            if (valid(y, row)) {
                result += dfs(y + 1, n);
            }

        }
        
        return result;
    }
    
    boolean valid(int y, int[] row) {
        for (int x = 0; x < y; x++) {
            if (row[y] == row[x]) return false;
            if (Math.abs(y - x) == Math.abs(row[y] - row[x])) return false;
        }
        return true;
    }
}