import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {        
        List<String> noX = new ArrayList<>();
        List<String> yesX = new ArrayList<>();
                
        int maxNumber = 0;
        for (String exp : expressions) {
            String[] split = exp.split(" ");
            if (split[4].equals("X")) {
                yesX.add(exp);
            } else {
                noX.add(exp);
                maxNumber = Math.max(maxNumber, getMaxDigit(split[4]));
            }
            maxNumber = Math.max(maxNumber, getMaxDigit(split[0]));
            maxNumber = Math.max(maxNumber, getMaxDigit(split[2]));
        }
        
        maxNumber = Math.max(2, maxNumber + 1); // 최소 진법은 2
        
        Set<Integer> able = new HashSet<>();
        for (int i = maxNumber; i <= 9; i++) {
            able.add(i);
        }
        
        for (String exp : noX) {
            String[] split = exp.split(" ");
            String a = split[0].trim();
            String op = split[1].trim();
            String b = split[2].trim();
            String expect = split[4].trim();

            boolean[] check = new boolean[10];
            for (int base = maxNumber; base <= 9; base++) {
                int aa = Integer.parseInt(a, base);
                int bb = Integer.parseInt(b, base);
                int result = 0;
                if (op.equals("+")) {
                    result = aa + bb;
                } else if (op.equals("-")) {
                    result = aa - bb;
                }
                String resultStr = Integer.toString(result, base);
                if (resultStr.equals(expect)) {
                    check[base] = true;
                }
            }
            
            for (int base = 2; base <= 9; base++) {
                if (!check[base]) {
                    able.remove(base);
                }
            }
        }
                
        String[] answer = new String[yesX.size()];
        for (int i = 0; i < yesX.size(); i++) {
            String exp = yesX.get(i);
            String[] split = exp.split(" ");
            String a = split[0].trim();
            String op = split[1].trim();
            String b = split[2].trim();
            
            Set<String> temp = new HashSet<>();
            for (int base : able) {
                int aa = Integer.parseInt(a, base);
                int bb = Integer.parseInt(b, base);
                int result = 0;
                if (op.equals("+")) {
                    result = aa + bb;
                } else if (op.equals("-")) {
                    result = aa - bb;
                }
                temp.add(Integer.toString(result, base));
            }
            
            if (temp.size() == 1) {
                answer[i] = String.format("%s %s %s = %s", a, op, b, temp.iterator().next());
            } else {
                answer[i] = String.format("%s %s %s = ?", a, op, b);
            }
        }
        
        return answer;
    }

    private int getMaxDigit(String s) {
        int maxDigit = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                maxDigit = Math.max(maxDigit, c - '0');
            }
        }
        return maxDigit;
    }
}
