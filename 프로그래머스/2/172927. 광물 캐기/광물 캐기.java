import java.util.*;

class Solution {
    
    class Data {
        int mineValue;
        int[] count;
        boolean possible = false;
        
        Data(int mineValue, int[] count, boolean possible) {
            this.mineValue = mineValue;
            this.count = new int[count.length]; 
            for (int i = 0; i < count.length; i++) {
                this.count[i] = count[i];
            }
            this.possible = possible;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        List<Data> list = new ArrayList<>();
        int mineValue = 0;
        int[] count = new int[3]; // dia, iron, stone
        int curPossible = 0;
        int possibleMax = (picks[0] + picks[1] + picks[2]) * 5;
        
        for (int i = 0; i < minerals.length; i++) {
            String mine = minerals[i];
            if (mine.equals("diamond")) {
                mineValue += 25;
                count[0]++;
            } else if (mine.equals("iron")) {
                mineValue += 5;
                count[1]++;
            } else {
                mineValue += 1;
                count[2]++;
            }
            
            curPossible++;
            if ((i + 1) % 5 == 0 && curPossible < possibleMax) {
                list.add(new Data(mineValue, count, true));    
                mineValue = 0;
                for (int j = 0; j < count.length; j++) {
                    count[j] = 0;
                }
            }
            
            if (curPossible == possibleMax) {
                if (mineValue != 0) {
                    list.add(new Data(mineValue, count, true));    
                }
                mineValue = 0;
                break;
            }
        }
        if (mineValue != 0 && curPossible < possibleMax) {
            list.add(new Data(mineValue, count, true));    
        }
    
        list.sort((i, j) -> Integer.compare(j.mineValue, i.mineValue));
        for (Data l: list) {
            System.out.println(l.possible);
            if (!l.possible) continue;
            
            if (picks[0] > 0) {
                answer += l.count[0];
                answer += l.count[1];
                answer += l.count[2];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += (l.count[0] * 5);
                answer += l.count[1];
                answer += l.count[2];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += (l.count[0] * 25);
                answer += (l.count[1] * 5);
                answer += l.count[2];
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }
}