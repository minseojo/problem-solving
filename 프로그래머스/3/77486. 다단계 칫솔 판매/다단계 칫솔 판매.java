import java.util.*;

class Solution {
    
    class Member {
        String name;
        int amount;
        Member parent;
        Member(String name, int amount, Member parent) {
            this.name = name;
            this.amount = amount;
            this.parent = parent;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> sell = new LinkedHashMap<>();
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            sell.put(enroll[i], 0);
            result.put(enroll[i], 0);
        }
        
        for (int i = 0 ; i < seller.length; i++) {
            sell.put(seller[i], sell.get(seller[i]) + amount[i] * 100);
        }
        
        Map<String, Member> members = new LinkedHashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            String en = enroll[i];
            String refer = referral[i];
            Member referMember = members.getOrDefault(refer, new Member(refer, 0, null));
            Member member = new Member(en, 0, referMember);
            members.put(en, member);
        }
        
        Member sam = members.get("sam");
        
        for (int i = 0; i < seller.length; i++) {
            int remainAmount = amount[i] * 100;
            Member m = members.get(seller[i]);
            while (m != null) {
                m.amount += (remainAmount / 10 * 9 + remainAmount % 10);
                remainAmount = remainAmount / 10;
                m = m.parent;
            }
        }
        
        int pos = 0;
        for (String i : result.keySet()) {
            answer[pos++] = members.get(i).amount;
            System.out.println(i + " " + members.get(i).amount);
        }
        
        return answer;
    }
}

// . 단, 10% 를 계산할 때에는 원 단위에서 절사하며, 10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다.