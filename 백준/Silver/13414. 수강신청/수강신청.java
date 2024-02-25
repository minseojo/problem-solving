import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < l; i++) {
            String name = br.readLine();
            map.put(name, i);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> Integer.compare(map.get(o1), map.get(o2)));

        int pos = 0;
        for (String s : keySet) {
            System.out.println(s);
            pos++;
            if (pos == k) break;
        }
    }
}
