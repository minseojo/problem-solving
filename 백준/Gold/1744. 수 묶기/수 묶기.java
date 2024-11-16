import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) zeroCount++;
            else if (x < 0) neg.add(x);
            else pos.add(x);
        }

        int answer = 0;
        pos.sort(null);
        neg.sort(null);

        int posLen = pos.size();
        int negLen = neg.size();

        if (posLen == 1) {
            answer += pos.get(0);
        }else if (posLen % 2 == 0) {
            for (int i = pos.size() - 1; i >= 0; i -= 2) {
                answer += Math.max(pos.get(i) + pos.get(i - 1), pos.get(i) * pos.get(i - 1));
            }
        } else {
            for (int i = pos.size() - 1; i >= 1; i -= 2) {
                answer += Math.max(pos.get(i) + pos.get(i - 1), pos.get(i) * pos.get(i - 1));
            }
            answer += pos.get(0);
        }


        if (negLen == 1){
            if (zeroCount == 0) answer += neg.get(0);
        } else if ((negLen % 2) == 0) {
            for (int i = 0; i < negLen; i += 2) {
                answer += (neg.get(i) * neg.get(i + 1));
            }
        } else {
            for (int i = 0; i < negLen - 1; i += 2) {
                answer += (neg.get(i) * neg.get(i + 1));
            }
            if (zeroCount == 0) answer += neg.get(negLen - 1);
        }

        System.out.println(answer);
    }

}