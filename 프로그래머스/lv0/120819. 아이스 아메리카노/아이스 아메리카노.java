class Solution {
    private final static int iced_americano = 5500;
    public int[] solution(int money) {
        return new int[]{money / iced_americano, money - iced_americano *(money / iced_americano)};
    }
}