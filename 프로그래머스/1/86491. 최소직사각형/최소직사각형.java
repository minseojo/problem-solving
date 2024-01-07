class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0, maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];
            if (width < height) {
                int temp = width;
                width = height;
                height = temp;
            }
            
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        

        return maxWidth * maxHeight;
    }
}