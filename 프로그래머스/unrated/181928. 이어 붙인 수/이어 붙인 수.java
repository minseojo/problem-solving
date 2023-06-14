class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "", even = "";
        for(int num : num_list) {
            if (num % 2 == 0) {
                odd += (char) (num + '0');
            }
            else if (num % 2 == 1) {
                even += (char) (num + '0');
            }
        }
        //return Integer.valueOf(odd) + Integer.valueOf(even);
        return Integer.parseInt(odd) + Integer.parseInt(even);

    }
}