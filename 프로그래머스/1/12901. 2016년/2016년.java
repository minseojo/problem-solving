class Solution {
    public String solution(int a, int b) {     
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] monthDays = {-1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = 1;
        int totalDay = -1;
        while (month <= a) {
            if (month < a) {
                totalDay += monthDays[month];
            } else if (month == a) {
                totalDay += b;
            }
            month++;
        }
        return days[totalDay % 7];
    }
}