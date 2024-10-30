import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = { 1, 0, -1, 0 }; // 우 상 좌 하
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            draw(stoi(st.nextToken()), stoi(st.nextToken()), getDirections(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        System.out.println(countSquare());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void draw(int x, int y, List<Integer> directions) {
        visited[x][y] = true;
        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];
            visited[x][y] = true;
        }
    }

    static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
                int direction = (directions.get(j) + 1) % 4;
                directions.add(direction);
            }
        }

        return directions;
    }

    static int countSquare() {
        int count = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) count++;
            }
        }

        return count;
    }
}