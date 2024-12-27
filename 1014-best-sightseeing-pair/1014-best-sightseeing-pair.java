class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxSum = values[0] + 0;
        int result = values[0] + values[1] + 0 - 1;
        for(int j = 1; j < values.length; j++){
			result = Math.max(maxSum + values[j] - j, result);
            maxSum = Math.max(values[j] + j, maxSum);
        }

        return result;
    }
}