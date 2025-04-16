import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    static class Position {
        int r;
        int c;

        private Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Device {
        Position[] positions; // [0]: 위칸, [1]: 아래칸

        void updatePositions(Position[] positions) {
            this.positions = positions;
        }

        int[][] run(int[][] A) {
            int[][] result = new int[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) System.arraycopy(A[i], 0, result[i], 0, A[0].length);

            clean(A, result, positions[0], true);  // 위: 반시계
            clean(A, result, positions[1], false); // 아래: 시계

            return result;
        }

        private void clean(int[][] A, int[][] result, Position p, boolean isCounterClockwise) {
            int r = p.r;
            int c = p.c + 1;
            int maxR = A.length - 1;
            int maxC = A[0].length - 1;

            result[r][c] = 0;
            if (isCounterClockwise) {
                for (; c < maxC; c++) result[r][c + 1] = A[r][c];
                for (; r > 0; r--) result[r - 1][c] = A[r][c];
                for (; c > 0; c--) result[r][c - 1] = A[r][c];
                for (; r < p.r; r++) result[r + 1][c] = A[r][c];
            } else {
                for (; c < maxC; c++) result[r][c + 1] = A[r][c];
                for (; r < maxR; r++) result[r + 1][c] = A[r][c];
                for (; c > 0; c--) result[r][c - 1] = A[r][c];
                for (; r > p.r; r--) result[r - 1][c] = A[r][c];
            }
            result[p.r][p.c] = -1; // 공기청정기 유지
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] A = new int[R][C];
        for (int r = 0; r < R; r++) {
            StringTokenizer values = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                A[r][c] = Integer.parseInt(values.nextToken());
            }
        }

        System.out.println(solution(T, A));
    }

    private static int solution(int T, int[][] A) {
        int result = 0;

        Device device = new Device();
        device.updatePositions(findDevicePosition(A));

        while (T-- > 0) {
            diffuseDust(A); // 미세먼지 확산
            A = device.run(A); // 공기 청정기 돌리기
        }

        // 남은 미세먼지 합 구하기
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (A[r][c] > 0) result += A[r][c];
            }
        }

        return result;
    }
    
    private static Position[] findDevicePosition(int[][] A) {
        List<Position> positions = new ArrayList<>();

        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (A[r][c] == -1) {
                    positions.add(new Position(r, c));
                }
            }
        }

        return positions.toArray(new Position[0]);
    }

    private static void diffuseDust(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] temp = new int[R][C];
        for (int r = 0; r < R; r++) System.arraycopy(A[r], 0, temp[r], 0, C);

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] < 5) continue;
                int spread = A[r][c] / 5, count = 0;

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C || A[nr][nc] == -1) continue;
                    temp[nr][nc] += spread;
                    count++;
                }
                temp[r][c] -= spread * count;
            }
        }

        for (int r = 0; r < R; r++) System.arraycopy(temp[r], 0, A[r], 0, C);
    }

}
