class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int maxLen = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLen; i++) {
            int v1i = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int v2i = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (v1i == v2i) {
                if (i == maxLen-1) return 0;
                else continue;
            }
            if (v1i > v2i) return 1;
            else return -1;
        }

        return Integer.MAX_VALUE; // 도달 불가
    }
}