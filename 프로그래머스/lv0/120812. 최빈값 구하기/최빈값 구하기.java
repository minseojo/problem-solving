import java.util.*;
class Solution {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }
}
/*
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
*/