class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int size = num2 - num1 + 1;
        int[] result = new int[size];
        System.arraycopy(numbers, num1, result, 0, size);
        return result;
    }
}