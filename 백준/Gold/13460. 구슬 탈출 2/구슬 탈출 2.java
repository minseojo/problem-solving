import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static char[][] board;
    private static boolean[][][][] visited;
    private final static int[] dy = {-1, 1, 0, 0};
    private final static int[] dx = {0, 0, -1, 1};

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Node {
        Point red;
        Point blue;

        public Node() {
        }

        public Node(Point red, Point blue) {
            this.red = red;
            this.blue = blue;
        }

        public void setRed(Point red) {
            this.red = red;
        }

        public void setBlue(Point blue) {
            this.blue = blue;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        Node node = new Node();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    node.setRed(new Point(i, j));
                } else if (board[i][j] == 'B') {
                    node.setBlue(new Point(i, j));
                }
            }
        }

        System.out.println(bfs(node));
    }

    private static int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        visited[node.red.y][node.red.x][node.blue.y][node.blue.x] = true;
        q.add(node);

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                Point red = Objects.requireNonNull(cur).red;
                Point blue = cur.blue;

                if (cnt >= 10) {
                    return -1;
                }

                for (int dir = 0; dir < 4; dir++) {
                    Point nextRed = move(red, dir);
                    Point nextBlue = move(blue, dir);

                    if (board[nextBlue.y][nextBlue.x] == 'O') continue; // 파란 공이 구멍에 빠지면 무시
                    if (board[nextRed.y][nextRed.x] == 'O') return cnt + 1; // 빨간 공이 구멍에 빠지면 성공

                    if (nextRed.y == nextBlue.y && nextRed.x == nextBlue.x) { // 두 공이 겹치는 경우
                        switch (dir) {
                            case 0: // 위
                                if (red.y > blue.y) nextRed.y += 1;
                                else nextBlue.y += 1;
                                break;
                            case 1: // 아래
                                if (red.y > blue.y) nextBlue.y -= 1;
                                else nextRed.y -= 1;
                                break;
                            case 2: // 왼쪽
                                if (red.x > blue.x) nextRed.x += 1;
                                else nextBlue.x += 1;
                                break;
                            case 3: // 오른쪽
                                if (red.x > blue.x) nextBlue.x -= 1;
                                else nextRed.x -= 1;
                                break;
                        }
                    }

                    if (!visited[nextRed.y][nextRed.x][nextBlue.y][nextBlue.x]) {
                        visited[nextRed.y][nextRed.x][nextBlue.y][nextBlue.x] = true;
                        q.add(new Node(nextRed, nextBlue));
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    private static Point move(Point p, int dir) {
        int ny = p.y;
        int nx = p.x;

        while (true) {
            ny += dy[dir];
            nx += dx[dir];
            if (board[ny][nx] == '#') {
                ny -= dy[dir];
                nx -= dx[dir];
                break;
            }
            if (board[ny][nx] == 'O') {
                break;
            }
        }

        return new Point(ny, nx);
    }
}
