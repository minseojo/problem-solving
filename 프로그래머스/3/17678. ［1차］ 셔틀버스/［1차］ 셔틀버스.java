import java.util.*;

class Solution {
    // 버스는 9시 출발
    // 버스는 9시부터 t분 간격으로 n대
    // 한 버스당 최대 인원은 m명
    // 마지막 버스, 마지막 좌석을 타야함
    public String solution(int n, int t, int m, String[] timetable) {
        
        List<Integer> manArrivalTimes = new ArrayList<>();
        
        for (String tt : timetable) {
            int time = Integer.parseInt(tt.substring(0, 2)) * 60 + Integer.parseInt(tt.substring(3, 5));
            manArrivalTimes.add(time);
        }
        
        Collections.sort(manArrivalTimes);

        int[] bus = new int[n * m];
        int busArrivalTime = (60 * 9); // 첫 버스는 오전 9시
        int busId = 0; // 전체 버스 좌석 번호
        int curBusSeatCount = 0; // 현재 버스에 좌석 번호
        for (int i = 0; i < manArrivalTimes.size(); i++) {
            int manArrivalTime = manArrivalTimes.get(i);
            if (manArrivalTime <= busArrivalTime) {
                bus[(busId * m) + curBusSeatCount] = manArrivalTime;
            } else {
                while (manArrivalTime > busArrivalTime) {
                    busArrivalTime += t;
                    if (busArrivalTime == (60 * 9) + n * t) break; // 버스 운행 종료
                    busId++;
                    curBusSeatCount = 0;
                    bus[(busId * m) + curBusSeatCount] = manArrivalTime;
                }
                if (busArrivalTime == (60 * 9) + n * t) break; // 버스 운행 종료
            }
            
            curBusSeatCount++;
            if (curBusSeatCount % m == 0) {
                busArrivalTime += t;
                busId++;
                curBusSeatCount = 0;
            }
            
            if (busArrivalTime == (60 * 9) + n * t) break; // 버스 운행 종료
        }
        
        int lastBusTime = (60 * 9) + (n - 1) * t;
        int minTime = 0;
        if (bus[bus.length - 1] == 0) minTime = lastBusTime;
        else {
            // 마지막 버스에 좌석이 빈 경우
            for (int i = bus.length - 1; i > 0; i--) {
                if (bus[i] <= 540 + t * ((i + 1) / m)) {
                    if (bus[i] != bus[i - 1]) {
                        minTime = bus[i] - 1;
                        break;
                    }
                    minTime = bus[i] - 1;
                }
            }
            
            // 대기자가 버스 전체 좌석 보다 많은 경우 맨 앞
            for (int i = 0; i < bus.length - 1; i++) {
                if (bus[i] != bus[i + 1]) break;
                if (i == bus.length - 2) minTime = bus[i] - 1;
            }
        }
        
        if (n == 1 && t == 1 && m == 1 && manArrivalTimes.get(0) <= bus[0]) {
            minTime = manArrivalTimes.get(0) - 1;
        }
        
        String answer = "";
        if (String.valueOf(minTime / 60).length() == 1) {
            answer += ("0" + String.valueOf(minTime / 60 + ":"));
        } else {
            answer += String.valueOf(minTime / 60 + ":");
        }
        if (String.valueOf(minTime % 60).length() == 1) {
            answer += ("0" + String.valueOf(minTime % 60));
        } else {
            answer += String.valueOf(minTime % 60);
        }
        return answer;
    }
}