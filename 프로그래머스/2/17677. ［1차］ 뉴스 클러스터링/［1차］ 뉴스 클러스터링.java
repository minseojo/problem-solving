import java.util.*;
// 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다
class Solution {
    public int solution(String str1, String str2) {
        int MULTI = 65536;

        
        str1 = str1.toUpperCase();
        int[][] countSet1 = new int[26][26];  
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            if (!('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z')) {
                continue;   
            }
            if (!('A' <= tmp.charAt(1) && tmp.charAt(1) <= 'Z')) {
                continue;   
            }
            countSet1[tmp.charAt(0) - 'A'][tmp.charAt(1) - 'A']++;
        }
        
        str2 = str2.toUpperCase();
        int[][] countSet2 = new int[26][26];  
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            if (!('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z')) {
                continue;   
            }
            if (!('A' <= tmp.charAt(1) && tmp.charAt(1) <= 'Z')) {
                continue;   
            }
            countSet2[tmp.charAt(0) - 'A'][tmp.charAt(1) - 'A']++;
        }
        
        int retainSize = 0;
        int addSize = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                retainSize += Math.min(countSet1[i][j], countSet2[i][j]);
                addSize += Math.max(countSet1[i][j], countSet2[i][j]);
            }
        }
        
        if (addSize == 0) {
            return 1 * MULTI;
        }
        double retainDivideAdd = (double) retainSize / addSize; 
        return (int) (retainDivideAdd * MULTI);
    }
}