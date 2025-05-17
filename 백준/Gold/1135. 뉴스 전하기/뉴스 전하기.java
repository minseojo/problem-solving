import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }

        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree.get(parent).add(i);
            }
        }

        System.out.println(dfs(root, tree));
    }

    public static int dfs(int node, Map<Integer, List<Integer>> tree) {
        List<Integer> times = new ArrayList<>();

        for (int child : tree.get(node)) {
            times.add(dfs(child, tree)); // 자식들의 전파 시간 계산
        }

        // 가장 오래 걸리는 부하부터 먼저 전화해야 최소 시간
        times.sort(Comparator.reverseOrder());

        int max = 0;
        for (int i = 0; i < times.size(); i++) {
            max = Math.max(max, times.get(i) + i + 1); // 전화 순서 고려 (1분씩 딜레이)
        }

        return max;
    }

}
