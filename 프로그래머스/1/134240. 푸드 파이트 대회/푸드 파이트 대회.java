class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] / 2 > 0) {
                for (int j = 0; j < food[i] / 2; j++) {
                    sb.append(i);   
                }
            }
        }
        StringBuilder sbReverse = new StringBuilder(sb.toString());
        sb.append(0);
        sb.append(sbReverse.reverse().toString());
        
        return sb.toString();
    }
}