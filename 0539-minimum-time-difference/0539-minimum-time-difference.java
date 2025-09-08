class Solution {
    public int findMinDifference(List<String> timePoints) {
        int answer = Integer.MAX_VALUE;
        int n = timePoints.size();

        Collections.sort(timePoints);

        for (int i = 0; i < n; i++) {
            String currentTime = "", nextTime = "";
            
            if (i == n-1) {
                currentTime = timePoints.get(0);
                nextTime = timePoints.get(i);
            } else {
                currentTime = timePoints.get(i);
                nextTime = timePoints.get(i + 1);
            }

            int currentHour = Integer.valueOf(currentTime.substring(0, 2)) * 60;
            int currentMinute = Integer.valueOf(currentTime.substring(3, 5));
            int nextHour = Integer.valueOf(nextTime.substring(0, 2)) * 60;
            int nextMinute = Integer.valueOf(nextTime.substring(3, 5));

            // 시계방향
            answer = Math.min(answer, nextHour + nextMinute - (currentHour + currentMinute));

            // 반시계방향
            answer = Math.min(answer, (currentHour + (24 * 60)) + currentMinute - (nextHour + nextMinute));
        }

        return answer;
    }
}

// class Solution {
//     public int findMinDifference(List<String> timePoints) {
//         int answer = Integer.MAX_VALUE;

//         List<Integer> timesByMinute = new ArrayList<>();
//         for (String timePoint : timePoints) {
//             int hour = Integer.valueOf(timePoint.substring(0, 2)) * 60;
//             int minute = Integer.valueOf(timePoint.substring(3, 5));
//             timesByMinute.add(hour + minute);
//         }

//         Collections.sort(timesByMinute);
//         for (int i = 0; i < timesByMinute.size() - 1; i++) {
//             answer = Math.min(answer, timesByMinute.get(i + 1) - timesByMinute.get(i));
//         }

//         return answer;
//     }
// }