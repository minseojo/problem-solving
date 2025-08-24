class Solution {
    public int longestSubarray(int[] nums) {
        int answer = 0;
        int n = nums.length;

        int[] sequecnes = new int[n];
        int sequence = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                sequence++;
            } else {
                sequence = 0;
            }
            sequecnes[i] = sequence;
        }

        int[] parent = new int[n];
        int id = 0;
        int maxSequence = 0;
        for (int i = n-1; i >= 0; i--) {
            if (sequecnes[i] > 0) {
                maxSequence = Math.max(maxSequence, sequecnes[i]);
            } else {
                id++;
                maxSequence = 0;
            }
            parent[i] = id;
            sequecnes[i] = maxSequence;
        }

        for (int i = n-1; i >= 0; i--) {
            if (i > 2 && parent[i] != parent[i-2]) {
                answer = Math.max(answer, sequecnes[i] + sequecnes[i-2]);
            }
            answer = Math.max(answer, sequecnes[i]);
        }

        if (id == 0) answer -= 1;
        return answer;
    }
}