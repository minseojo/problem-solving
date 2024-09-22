class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoLen = convertTimeToInt(video_len);
        int cur = convertTimeToInt(pos);
        int opStart = convertTimeToInt(op_start);
        int opEnd = convertTimeToInt(op_end);

        for (String c : commands) {
            cur = check(videoLen, cur, opStart, opEnd);
            if (c.equals("next")) {
                cur += 10;
            }
            if (c.equals("prev")) {
                cur -= 10;
            }
        }
        cur = check(videoLen, cur, opStart, opEnd);
        

        return convertTimeToString(cur);
    }
    
    int check(int videoLen, int cur, int opStart, int opEnd) {
        if (cur < 0) cur = 0;
        if (cur > videoLen) cur = videoLen;
        if (cur >= opStart && cur <= opEnd) cur = opEnd;
        return cur;
    }
    
    int convertTimeToInt(String time) {
        String[] splitTime = time.split(":");
        return Integer.valueOf(splitTime[0]) * 60 + Integer.valueOf(splitTime[1]);
    }
    
    String convertTimeToString(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}