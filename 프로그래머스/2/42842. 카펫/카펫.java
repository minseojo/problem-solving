class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int yWidth = i;
                int yHeight = yellow / i;
                int bWidth = yWidth + 2;
                int bHeight = yHeight;
                if (bWidth < bHeight + 2) {
                    continue;
                }
                if (bWidth * 2 + bHeight * 2 == brown) {
                    return new int[] {bWidth, bHeight + 2};
                }
                System.out.println(yWidth + " " + yHeight + " " + bWidth + " " + bHeight);
            }
        }
        
        return new int[] {-1, -1};
    }
}