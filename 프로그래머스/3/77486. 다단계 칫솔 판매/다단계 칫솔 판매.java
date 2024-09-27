import java.util.*;

class Solution {

    private static final String BOSS = "-";
    private Map<String, Integer> profit = new HashMap<>();
    private Map<String, String> parent = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        buildParent(enroll, referral);
        for (int i = 0; i < seller.length; i++)
            updateProfit(seller[i], 100*amount[i]);

        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++)
            answer[i] = profit.getOrDefault(enroll[i], 0);
        return answer; 
    }


    private void updateProfit(String p, int earn) {
        String person = p;
        do {
            int stolen = earn / 10;
            profit.put(person, earn - stolen + profit.getOrDefault(person, 0));     
            person = parent.get(person);
            earn = stolen;
        } while (earn!= 0 && !BOSS.equals(person));
    }

    private void buildParent(String[] enroll, String[] ref) {
        for (int i = 0; i < enroll.length; i++)
            parent.put(enroll[i], ref[i]);
    }
}