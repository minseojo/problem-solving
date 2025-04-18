import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }; // 북/동/남/서


    private static final int WALL = 1;
    private static final int CLEAN = 2;
    private static final int NOT_CLEAN = 0;

    static class Data {
        int r;
        int c;
        int dir;

        Data(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(r, c, d, room));
    }

    private static int solution(int r, int c, int d, int[][] room) {
        int result = 0;
        int n = room.length;
        int m = room[0].length;
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(r, c, d));

        while (!q.isEmpty()) {
            Data data = q.poll();
            int curR = data.r;
            int curC = data.c;
            int curDir = data.dir;

            if (room[curR][curC] == NOT_CLEAN) {
                room[curR][curC] = CLEAN;
                result++;
            }

            boolean cleanUp = false;
            for (int i = 0; i < dirs.length; i++) {
                int nextDir = (curDir - i - 1 + dirs.length) % dirs.length;
                int nextR = curR + dirs[nextDir][0];
                int nextC = curC + dirs[nextDir][1];

                if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && room[nextR][nextC] == NOT_CLEAN) {
                    cleanUp = true;
                    q.add(new Data(nextR, nextC, nextDir));
                    break;
                }
            }

            if (!cleanUp) {
                int nextDir = (curDir + 2) % dirs.length;
                int nextR = curR + dirs[nextDir][0];
                int nextC = curC + dirs[nextDir][1];
                if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && room[nextR][nextC] != WALL) {
                    q.add(new Data(nextR, nextC, curDir));
                }
            }
        }

        return result;
    }
}
