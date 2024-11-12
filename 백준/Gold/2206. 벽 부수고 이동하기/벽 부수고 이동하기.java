import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] a;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y;
        int x;
        int breakCount;

        Node (int y, int x, int breakCount) {
            this.y = y;
            this.x = x;
            this.breakCount = breakCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        q.offer(new Node(0, 0, 0));
        visited[0][0][0] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            result++;
            while (size-- > 0) {
                Node cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                if (y == n -1 && x == m - 1) return result;
                int breakCount = cur.breakCount;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if (breakCount == 0) {
                        if (!visited[ny][nx][breakCount] && a[ny][nx] == 0) {
                            q.add(new Node(ny, nx, breakCount));
                            visited[ny][nx][breakCount] = true;
                        }
                        if (!visited[ny][nx][breakCount + 1] && a[ny][nx] == 1) {
                            q.add(new Node(ny, nx, breakCount + 1));
                            visited[ny][nx][breakCount + 1] = true;
                        }
                    } else if (breakCount == 1) {
                        if (!visited[ny][nx][breakCount] && a[ny][nx] == 0) {
                            q.add(new Node(ny, nx, breakCount));
                            visited[ny][nx][breakCount] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

}