import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            temp = temp.substring(1, temp.length() - 1);
            String[] x = temp.split(",");
            List<Integer> list = new LinkedList<>();
            if (n != 0) {
                for (String s : x) {
                    list.add(Integer.parseInt(s));
                }
            }

            boolean isError = false;
            int reverseCount = 0;
            for (char command : commands) {
                if (command == 'R') {
                    reverseCount++;
                } else if (command == 'D') {
                    if (list.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    } else {
                        if (reverseCount % 2 == 0) {
                            list.remove(0);
                        } else if (reverseCount % 2 == 1) {
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }

            if (!isError) {
                StringBuilder result = new StringBuilder();
                result.append("[");
                if (reverseCount % 2 == 1) {
                    Collections.reverse(list);
                }
                for (Integer integer : list) {
                    result.append(integer + ",");
                }
                if (!list.isEmpty()) result.deleteCharAt(result.length() - 1);
                result.append("]");
                System.out.println(result);
            }
        }
    }
}
