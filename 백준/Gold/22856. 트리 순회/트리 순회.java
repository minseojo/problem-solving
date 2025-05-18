import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int value;
        Node left;
        Node right;

        Node (int value){
            this.value = value;
        }

        void setChild (Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    static int answer = 0;
    static boolean end = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        Node[] node = new Node[100001];
        for (int i = 1; i <= n; i++) {
            node[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b == -1 && c != -1) {
                node[a].setChild(null, node[c]);
            } else if (b != -1 && c == -1) {
                node[a].setChild(node[b], null);
            } else if (b != -1 && c != -1) {
                node[a].setChild(node[b], node[c]);
            }
        }

        Node lastNode = null;
        Node root = node[1];
        while (root.right != null) {
            if (root.right == null && root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
            lastNode = root;
        }
        if (lastNode == null) lastNode = node[1];

        boolean[] visited = new boolean[n + 1];
        dfs(node[1], lastNode, visited);
        System.out.println(answer);

    }

    private static void dfs(Node root, Node lastNode, boolean[] visited) {
        visited[root.value] = true;

        if (root.left != null) {
            if (!visited[root.left.value]) {
                answer++;
                dfs(root.left, lastNode, visited);
            }
        }

        if (root.right != null) {
            if (!visited[root.right.value]) {
                answer++;
                dfs(root.right, lastNode, visited);
            }
        }

        if (root == lastNode) {
            end = true;
            return;
        }

        if (!end) {
            answer++;
        }
    }
}
