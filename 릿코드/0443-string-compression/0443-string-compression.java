class Solution {
    public int compress(char[] chars) {
        int size = chars.length;
        int index = 0, count = 0;
        for (int i=0; i<size; i++) {
            count++;
            if (i+1 == size || chars[i] != chars[i+1]) {
                chars[index++] = chars[i];
                if (count != 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }
                count = 0;
            }
        }
        return index;
    }
}

