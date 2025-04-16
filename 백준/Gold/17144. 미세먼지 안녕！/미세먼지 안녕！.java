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
            int row = A.length - 1;
            int col = A[0].length - 1;

            int[][] result = new int[A.length][A[0].length];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    result[r][c] = A[r][c];
                }
            }
            Position top = positions[0];
            Position bottom = positions[1];

            // 윗공기 정화 (반시계 방향)
            int curR = top.r;
            int curC = top.c + 1;
            while (curC < col) {
                curC++;
                result[curR][curC] = A[curR][curC - 1];
            }
            while(curR > 0) {
                curR--;
                result[curR][curC] = A[curR + 1][curC];
            }
            while(curC > 0) {
                curC--;
                result[curR][curC] = A[curR][curC + 1];
            }
            while(curR < top.r) {
                curR++;
                result[curR][curC] = A[curR - 1][curC];
            }
            while(curC < top.c) {
                curC++;
                result[curR][curC] = A[curR][curC - 1];
            }
            result[curR][curC] = A[top.r][top.c];
            result[curR][curC + 1] = 0;

            // 아랫공기 정화 (시계 방향)
            curR = bottom.r;
            curC = bottom.c + 1;
            while (curC < col) {
                curC++;
                result[curR][curC] = A[curR][curC - 1];
            }
            while(curR < row) {
                curR++;
                result[curR][curC] = A[curR - 1][curC];
            }
            while(curC > 0) {
                curC--;
                result[curR][curC] = A[curR][curC + 1];
            }
            while(curR > bottom.r) {
                curR--;
                result[curR][curC] = A[curR + 1][curC];
            }
            while(curC < bottom.c) {
                curC++;
                result[curR][curC] = A[curR][curC - 1];
            }
            result[curR][curC] = A[bottom.r][bottom.c];
            result[curR][curC + 1] = 0;

            return result;
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
        Queue<Position> dusts = new LinkedList<>();
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (A[r][c] > 0) {
                    dusts.add(new Position(r, c));
                }
            }
        }

        int[][] prevA = new int[A.length][A[0].length];
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                prevA[r][c] = A[r][c];
            }
        }

        int[][] temp = new int[A.length][A[0].length];
        while (!dusts.isEmpty()) {
            Position curPosition = dusts.poll();
            int curR = curPosition.r;
            int curC = curPosition.c;

            int count = 0;
            for (int[] dir : dirs) {
                int nextR = curR + dir[0];
                int nextC = curC + dir[1];

                if (nextR < 0 || nextC < 0 || nextR > A.length - 1 || nextC > A[0].length - 1) continue;
                if (prevA[nextR][nextC] == -1) continue;
                A[nextR][nextC] += (prevA[curR][curC] / 5);
                count++;
            }
            temp[curR][curC] = (prevA[curR][curC] / 5) * count;
        }

        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                A[r][c] -= temp[r][c];
            }
        }
    }
}
