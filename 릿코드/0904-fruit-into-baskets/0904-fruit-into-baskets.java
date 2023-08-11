class Solution {
  public int totalFruit(int[] fruits) {
    int answer = 0;
    Map<Integer, Integer> count = new HashMap<>();
    for(int l=0, r=0; r<fruits.length; r++) {
        count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
        while (count.size() > 2) {
            count.put(fruits[l], count.get(fruits[l])-1);
            count.remove(fruits[l], 0);
            l++;
        }
        answer = Math.max(answer, r-l+1);
    }

    return answer;
  }
}
/*class Solution {
    public int totalFruit(int[] fruits) {
        int[] counts = new int[fruits.length];
        int max = 0;
        int currMax = 0;
        int typeCount = 0;
        int start = 0;
        
        for(int i = 0; i < fruits.length; i++) {
            if(counts[fruits[i]] == 0) typeCount++;
            counts[fruits[i]]++;
            currMax++;
            
            while(typeCount > 2 && start < i) {
                counts[fruits[start]]--;
                if(counts[fruits[start]] == 0) typeCount--;
                start++;
                currMax--;
            }
            
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}
*/
/*class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length == 1) return 1;

        int answer = 0;
        int first=-1, second=-1, count=0;
        for(int i=0; i<fruits.length; i++) {
            int l =i, r = i+1;
            first = fruits[l];
            second = -1;
            while(true){
                if(r >= fruits.length-1) break;
                if(first != fruits[r] && second == -1) second = fruits[r];
                if(first != fruits[r+1] && (second != -1 && second != fruits[r+1])) break;
                r++;
            }
            System.out.println(first + " " + second + " " + l + " " + r );
            answer = Math.max(answer, r-l+1);
        }
        return answer;
    }
}
*/