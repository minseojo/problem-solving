import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int size = emergency.length;
        int[] answer = new int[size];
        
        // 방어적 복사
        int[] copy_emergency = new int[size];
        System.arraycopy(emergency, 0, copy_emergency, 0, size);
        Arrays.sort(copy_emergency);
        // 순위 저장
        Map<Integer, Integer> map = new HashMap<>();
        int lank = emergency.length;
        for (int i = 0; i < size; i++) {
            map.put(copy_emergency[i], lank--);
        }
        // 탐색 + 순위 초기화
        for (int i = 0; i < size; i++) {
            answer[i] = map.get(emergency[i]);
        }
        return answer;
    }
}