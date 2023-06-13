class Solution {
    public double solution(int[] numbers) {
        int sum = 0;
        int size = numbers.length;
        for(int i : numbers) {
            sum += i;
        }
        return (double) sum/size;
    }
}