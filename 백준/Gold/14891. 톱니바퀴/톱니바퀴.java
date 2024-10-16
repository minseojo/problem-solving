import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static char S = '1';
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] cogwheels = new StringBuilder[4];
        for (int i = 0; i < 4; i++) {
            cogwheels[i] = new StringBuilder(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            cogwheels = run(cogwheels, start, dir);

        }

        for (int i = 0; i < 4; i++) {
            answer += calScore(cogwheels[i].toString(), i);
        }

        System.out.println(answer);
    }

    static StringBuilder[] run(StringBuilder[] cogwheels, int index, int dir) {
        if (visited[index]) return cogwheels;
        int a = 2, b = 6;
        int nextDir = dir * -1;
        visited[index] = true;

        // 왼쪽 탐색 및 회전
        if (index > 0 && !visited[index - 1] && cogwheels[index].charAt(b) != cogwheels[index - 1].charAt(a)) {
            cogwheels = run(cogwheels, index - 1, nextDir);
        }

        // 오른쪽 탐색 및 회전
        if (index < 3 && !visited[index + 1] && cogwheels[index].charAt(a) != cogwheels[index + 1].charAt(b)) {
            cogwheels = run(cogwheels, index + 1, nextDir);
        }

        // 현재 톱니바퀴 회전
        cogwheels[index] = fx(cogwheels, index, dir);

        return cogwheels;
    }



    static StringBuilder fx(StringBuilder[] cogwheels, int index, int dir) {
        StringBuilder sb = cogwheels[index];
        if (dir == 1) {
            sb.insert(0, cogwheels[index].charAt(sb.length() - 1));
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(cogwheels[index].charAt(0));
            sb.deleteCharAt(0);
        }
        return sb;
    }


    static int calScore(String cogwheel, int index) {
        if (cogwheel.charAt(0) == S) {
            if (index == 0) return 1;
            else if (index == 1) return 2;
            else if (index == 2) return 4;
            else if (index == 3) return 8;
        }

        return 0;
    }
}
