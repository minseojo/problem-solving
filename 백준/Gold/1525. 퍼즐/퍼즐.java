import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n = 3;
    static Set<String> visited = new HashSet<>();
    static String EXPECT = "123456780";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sb.append(st.nextToken());
            }
        }

        visited.add(sb.toString());
        System.out.println(bfs(sb));
    }

    static int bfs(StringBuilder sb) {
        int result = 0;
        Queue<StringBuilder> q = new LinkedList<>();
        q.add(sb);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                StringBuilder s = q.poll();
                if (s.toString().equals(EXPECT)) return result;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0') {
                        switch (i) {
                            case 0:
                                swapRight(s, i, q);
                                swapDown(s, i, q);
                                break;
                            case 1:
                                swapLeft(s, i, q);
                                swapRight(s, i, q);
                                swapDown(s, i, q);
                                break;
                            case 2:
                                swapLeft(s, i, q);
                                swapDown(s, i, q);
                                break;
                            case 3:
                                swapUp(s, i, q);
                                swapRight(s, i, q);
                                swapDown(s, i, q);
                                break;
                            case 4:
                                swapLeft(s, i, q);
                                swapRight(s, i, q);
                                swapUp(s, i, q);
                                swapDown(s, i, q);
                                break;
                            case 5:
                                swapLeft(s, i, q);
                                swapUp(s, i, q);
                                swapDown(s, i, q);
                                break;
                            case 6:
                                swapUp(s, i, q);
                                swapRight(s, i, q);
                                break;
                            case 7:
                                swapLeft(s, i, q);
                                swapUp(s, i, q);
                                swapRight(s, i, q);
                                break;
                            case 8:
                                swapLeft(s, i, q);
                                swapUp(s, i, q);
                                break;
                        }
                    }
                }
            }
            result++;
        }

        return -1;
    }

    static void swapLeft(StringBuilder sb, int idx, Queue<StringBuilder> q) {
        StringBuilder temp = new StringBuilder(sb);
        char a = sb.charAt(idx - 1);
        char b = sb.charAt(idx);
        temp.setCharAt(idx - 1, b);
        temp.setCharAt(idx, a);
        if (!visited.contains(temp.toString())) {
            q.add(temp);
            visited.add(temp.toString());
        }
    }

    static void swapRight(StringBuilder sb, int idx, Queue<StringBuilder> q) {
        StringBuilder temp = new StringBuilder(sb);
        char a = sb.charAt(idx + 1);
        char b = sb.charAt(idx);
        temp.setCharAt(idx + 1, b);
        temp.setCharAt(idx, a);
        if (!visited.contains(temp.toString())) {
            q.add(temp);
            visited.add(temp.toString());
        }
    }

    static void swapUp(StringBuilder sb, int idx, Queue<StringBuilder> q) {
        StringBuilder temp = new StringBuilder(sb);
        char a = sb.charAt(idx - 3);
        char b = sb.charAt(idx);
        temp.setCharAt(idx - 3, b);
        temp.setCharAt(idx, a);
        if (!visited.contains(temp.toString())) {
            q.add(temp);
            visited.add(temp.toString());
        }
    }

    static void swapDown(StringBuilder sb, int idx, Queue<StringBuilder> q) {
        StringBuilder temp = new StringBuilder(sb);
        char a = sb.charAt(idx + 3);
        char b = sb.charAt(idx);
        temp.setCharAt(idx + 3, b);
        temp.setCharAt(idx, a);
        if (!visited.contains(temp.toString())) {
            q.add(temp);
            visited.add(temp.toString());
        }
    }
}
