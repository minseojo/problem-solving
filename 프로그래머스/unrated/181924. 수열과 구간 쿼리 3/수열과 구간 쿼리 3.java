class Solution {
    
    static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    } 
    
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        for(int[] query : queries) {
            int a = query[0];
            int b = query[1];
            swap(a, b, result);
        }
        return result;
    }
}