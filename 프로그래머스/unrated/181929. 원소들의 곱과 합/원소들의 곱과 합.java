class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int multiple = 1;
        for (int num : num_list) {
            multiple *= num;
            sum += num;
        }
        sum *= sum;
        
        if (sum > multiple) return 1;
        else return 0;
    }
}