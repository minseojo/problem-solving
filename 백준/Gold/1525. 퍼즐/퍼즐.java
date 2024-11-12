import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int N = 3;
    static final String EXPECTED = "123456780";
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
        }
        
        visited.add(sb.toString());
        System.out.println(bfs(sb));
    }

    static int bfs(StringBuilder sb) {
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(sb);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                StringBuilder current = queue.poll();
                if (current.toString().equals(EXPECTED)) return moves;

                int zeroIndex = current.indexOf("0");
                for (int direction : new int[]{-1, 1, -3, 3}) {
                    int swapIndex = zeroIndex + direction;
                    if (isValidMove(zeroIndex, swapIndex)) {
                        swapAndAddToQueue(current, zeroIndex, swapIndex, queue);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    static boolean isValidMove(int zeroIndex, int swapIndex) {
        return swapIndex >= 0 && swapIndex < 9 &&
               !(zeroIndex % N == 2 && swapIndex % N == 0) &&
               !(zeroIndex % N == 0 && swapIndex % N == 2);
    }

    static void swapAndAddToQueue(StringBuilder sb, int zeroIndex, int swapIndex, Queue<StringBuilder> queue) {
        StringBuilder nextState = new StringBuilder(sb);
        char temp = nextState.charAt(zeroIndex);
        nextState.setCharAt(zeroIndex, nextState.charAt(swapIndex));
        nextState.setCharAt(swapIndex, temp);

        String nextStateStr = nextState.toString();
        if (!visited.contains(nextStateStr)) {
            queue.add(nextState);
            visited.add(nextStateStr);
        }
    }
}
