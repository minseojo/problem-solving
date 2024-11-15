import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] a;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    static class Data {
        int y;
        int x;

        Data(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new char[n][m];
        Queue<Data> q = new LinkedList<>();
        Queue<Data> fireQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = temp.charAt(j);
                if (a[i][j] == 'J') {
                    q.add(new Data(i, j));
                } else if (a[i][j] == 'F') {
                    fireQ.add(new Data(i, j));
                }
            }
        }

        System.out.println(bfs(q, fireQ));
    }

    static String bfs(Queue<Data> q, Queue<Data> fireQ) {
        int result = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int fireSize = fireQ.size();

            while (fireSize-- > 0) {
                Data data = fireQ.poll();
                int y = data.y;
                int x = data.x;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (a[ny][nx] == '.' || a[ny][nx] == 'J') {
                        a[ny][nx] = 'F';
                        fireQ.add(new Data(ny, nx));
                    }
                }
            }

            while (size-- > 0) {
                Data data = q.poll();
                int y = data.y;
                int x = data.x;
                if (y == 0 || y == n - 1 || x == 0 || x == m - 1) return String.valueOf(result);
                for (int i = 0; i < 4; i++) {
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if (a[ny][nx] == '.') {
                            a[ny][nx] = 'J';
                            q.add(new Data(ny, nx));
                        }
                    }
                }
            }
            result++;
        }

        return "IMPOSSIBLE";
    }

}
