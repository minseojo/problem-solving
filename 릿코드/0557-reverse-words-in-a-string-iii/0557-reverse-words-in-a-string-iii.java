class Solution {
    public String reverseWords(String s) {

        char[] arr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(start, i-1, arr);
                start = i+1;
            } else if (i == arr.length-1) {
                reverse(start, i, arr);
            }
        }

        return new String(arr);
    }
    
    void reverse(int start, int end, char[] arr) {
        while(start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}