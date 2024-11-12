import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] a;
    static int[] dy = {-1, 0, 0, 1}; // 상, 좌, 우, 하
    static int[] dx = {0, -1, 1, 0};

    static int answer;
    static Fish fish = null;

    static class Fish {
        int y;
        int x;
        int size = 2;
        int feedCount = 0;

        Fish(int y, int x) {
            this.y = y;
            this.x = x;
        }

        void eat() {
            feedCount++;
            if (feedCount == size) {
                size++;
                feedCount = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                a[i][j] = x;
                if (x == 9) {
                    fish = new Fish(i, j);
                    a[i][j] = 0;
                }
            }
        }

        while (true) {
            boolean[][] visited = new boolean[n][n];
            int distance = bfs(visited);
            if (distance == -1) break;
            answer += distance;
        }
        System.out.println(answer);
    }

    static int bfs(boolean[][] visited) {
        Queue<Fish> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[2], o2[2]);
        });

        q.add(fish);
        visited[fish.y][fish.x] = true;
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Fish cur = q.poll();
                int y = cur.y;
                int x = cur.x;

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) continue;

                    if (a[ny][nx] > 0 && a[ny][nx] < fish.size) {
                        pq.add(new int[]{ny, nx, distance + 1});
                        visited[ny][nx] = true;
                    } else if (a[ny][nx] == 0 || a[ny][nx] == fish.size) {
                        q.add(new Fish(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }

            if (!pq.isEmpty()) {
                int[] target = pq.poll();
                fish.y = target[0];
                fish.x = target[1];
                fish.eat();
                a[fish.y][fish.x] = 0;
                return target[2];
            }
            distance++;
        }
        
        return -1;
    }
}
