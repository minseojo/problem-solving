class Solution {
    public int compareVersion(String version1, String version2) {

        String[] splitv1 = version1.split("\\.");
        String[] splitv2 = version2.split("\\.");
        int maxLen = Math.max(splitv1.length, splitv2.length);
        String[] v1 = new String[maxLen];
        String[] v2 = new String[maxLen];
        
        for (int i = 0; i < maxLen; i++) {
            if (i >= splitv1.length) {
                v1[i] = "0";
            } else {
                v1[i] = splitv1[i];
            }

            if (i >= splitv2.length) {
                v2[i] = "0";
            } else {
                v2[i] = splitv2[i];
            }
        }

        for (int i = 0; i < maxLen; i++) {
            int v1i = Integer.parseInt(v1[i]);
            int v2i = Integer.parseInt(v2[i]);
            
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