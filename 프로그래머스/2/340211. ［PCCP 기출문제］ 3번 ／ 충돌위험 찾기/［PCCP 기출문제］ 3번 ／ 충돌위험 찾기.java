import java.util.*;

class Solution {
    class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        Map<Integer, Point> pointCoords = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointCoords.put(i + 1, new Point(points[i][0], points[i][1]));
        }

        int dangerCount = 0;

        // 특정 시간에 로봇이 위치한 좌표를 저장하는 맵
        Map<String, Integer> robotPositions = new HashMap<>();

        // 각 로봇의 경로를 시뮬레이션
        for (int robotId = 0; robotId < routes.length; robotId++) {
            int currentTime = 0;

            // 로봇의 경로 시작 위치 설정
            Point startPoint = pointCoords.get(routes[robotId][0]);
            int sr = startPoint.r, sc = startPoint.c;

            // 첫 시작 위치 기록
            String key = sr + "," + sc + "," + currentTime;
            robotPositions.put(key, robotPositions.getOrDefault(key, 0) + 1);

            // 로봇이 각 포인트를 순서대로 이동
            for (int i = 1; i < routes[robotId].length; i++) {
                Point endPoint = pointCoords.get(routes[robotId][i]);
                int er = endPoint.r, ec = endPoint.c;

                // r 좌표부터 이동
                while (sr != er) {
                    if (sr < er) {
                        sr++;
                    } else {
                        sr--;
                    }
                    currentTime++;
                    key = sr + "," + sc + "," + currentTime;
                    robotPositions.put(key, robotPositions.getOrDefault(key, 0) + 1);
                }

                // c 좌표로 이동
                while (sc != ec) {
                    if (sc < ec) {
                        sc++;
                    } else {
                        sc--;
                    }
                    currentTime++;
                    key = sr + "," + sc + "," + currentTime;
                    robotPositions.put(key, robotPositions.getOrDefault(key, 0) + 1);
                }
            }
        }

        // 충돌 상황 확인
        for (int count : robotPositions.values()) {
            if (count > 1) {
                dangerCount++;
            }
        }

        return dangerCount;
    }
}
