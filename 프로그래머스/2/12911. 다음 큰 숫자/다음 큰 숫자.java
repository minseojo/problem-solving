class Solution {
    public int solution(int n) {

        int MAX_VALUE = 1_000_000;
        
        String bn = Integer.toBinaryString(n);
        bn = bn.replace("0", "");
        int bl = bn.length();
        
        for (int i = n + 1; i <= MAX_VALUE; i++) {
            String in = Integer.toBinaryString(i);
            in = in.replace("0", "");
            int il = in.length();
            if (il == bl) {
                return i;
            }
        }
        
        return -1;
    }
}