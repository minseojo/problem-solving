class Solution {
    public int solution(int[] array) {
        int num = 0, num_count = 0;
        boolean crash = false;
        int[] count = new int[1000];
        for(int i : array) {
            count[i]++;
        }
        for(int i=0; i<1000; i++) {
            if (count[i] == 0) continue;
            
            if (count[i] > num_count) {
                num = i;
                num_count = count[i];
                crash = false;
            } 
            else if (count[i] == num_count) {
                crash = true;
            }
        }
        
        if(crash) return -1;
        else return num;
    }
}