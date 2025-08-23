class Solution {

    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    public int minimumArea(int[][] grid) {
        int[] boundingBox = {MAX, MIN, MAX, MIN}; // 상,하,좌,우

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    boundingBox[0] = Math.min(boundingBox[0], i);
                    boundingBox[1] = Math.max(boundingBox[1], i + 1);
                    boundingBox[2] = Math.min(boundingBox[2], j);
                    boundingBox[3] = Math.max(boundingBox[3], j + 1);
                }
            }
        }
        
        return (boundingBox[1] - boundingBox[0]) * (boundingBox[3] - boundingBox[2]);
    }
}