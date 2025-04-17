import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < l; i++) {
            String id = br.readLine();
            map.remove(id); // 기존에 존재하면 삭제하고
            map.put(id, true); // 다시 넣기 → 가장 마지막에 위치
        }

        int count = 0;
        for (String id : map.keySet()) {
            if (count++ == k) break;
            System.out.println(id);
        }
    }
}
