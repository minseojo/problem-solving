import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            String[] x = temp.substring(1, temp.length() - 1).split(",");

            // 덱을 초기화
            ArrayDeque<Integer> dq = new ArrayDeque<>(n);
            if (n != 0) {
                for (String s : x) {
                    dq.add(Integer.parseInt(s));
                }
            }

            boolean isError = false;
            boolean isReversed = false;

            for (char command : commands) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else if (command == 'D') {
                    if (dq.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            dq.pollLast();
                        } else {
                            dq.pollFirst();
                        }
                    }
                }
            }

            if (!isError) {
                StringBuilder result = new StringBuilder();
                result.append("[");
                if (isReversed) {
                    while (!dq.isEmpty()) {
                        result.append(dq.pollLast()).append(",");
                    }
                } else {
                    while (!dq.isEmpty()) {
                        result.append(dq.pollFirst()).append(",");
                    }
                }

                // 마지막 쉼표 제거
                if (result.length() > 1) {
                    result.deleteCharAt(result.length() - 1);
                }
                result.append("]");
                System.out.println(result);
            }
        }
    }
}
