import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<List<Integer>> s = new ArrayList<>();
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            s.add(new ArrayList<>());
        }

        int y = 0;
        int x = m-1;
        int temp = a[y][x];
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            List<Integer> tempS = new ArrayList<>();
            for (int dir = 0; dir < 4; dir++) {
                while (true) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny < i || nx < i || ny > n-i-1 || nx > m-i-1) break;
                    tempS.add(temp);
                    y = ny;
                    x = nx;
                    temp = a[y][x];
                }
            }
            s.get(i).addAll(tempS);
            y++;
            x--;
            temp = a[y][x];
        }

        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            int size = r % s.get(i).size();
            List<Integer> tempS = new ArrayList<>();
            for (int j = s.get(i).size() - size; j < s.get(i).size(); j++) {
                tempS.add(s.get(i).get(j));
            }

            for (int j = 0; j < s.get(i).size() - size; j++) {
                tempS.add(s.get(i).get(j));
            }
            s.get(i).clear();
            s.get(i).addAll(tempS);
        }

        int[][] answer = new int[n][m];
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            int count = 0;
            y = i;
            x = m - i - 1;
            answer[y][x] = s.get(i).get(count++);
            for (int dir = 0; dir < 4; dir++) {
                while (true) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny < i || nx < i || ny > n-i-1 || nx > m-i-1 || count >= s.get(i).size()) break;
                    answer[ny][nx] = s.get(i).get(count++);
                    y = ny;
                    x = nx;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
