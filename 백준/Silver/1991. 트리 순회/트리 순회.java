import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[][] tree = new char[26][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (leftChild != '.') {
                tree[root][0] = leftChild;
            }
            if (rightChild != '.') {
                tree[root][1] = rightChild;
            }
        }

        preorder(0, tree);
        System.out.println();
        inorder(0, tree);
        System.out.println();
        postorder(0, tree);
    }

    private static void preorder(int node, char[][] tree) {
        if (tree == null) return;

        System.out.print((char) (node + 'A'));
        if ('A' <= tree[node][0] && tree[node][0] <= 'Z') preorder(tree[node][0] - 'A', tree);
        if ('A' <= tree[node][1] && tree[node][1] <= 'Z') preorder(tree[node][1] - 'A', tree);
    }

    private static void inorder(int node, char[][] tree) {
        if (tree == null) return;

        if ('A' <= tree[node][0] && tree[node][0] <= 'Z') inorder(tree[node][0] - 'A', tree);
        System.out.print((char) (node + 'A'));
        if ('A' <= tree[node][1] && tree[node][1] <= 'Z') inorder(tree[node][1] - 'A', tree);
    }

    private static void postorder(int node, char[][] tree) {
        if (tree == null) return;

        if ('A' <= tree[node][0] && tree[node][0] <= 'Z') postorder(tree[node][0] - 'A', tree);
        if ('A' <= tree[node][1] && tree[node][1] <= 'Z') postorder(tree[node][1] - 'A', tree);
        System.out.print((char) (node + 'A'));
    }
}
