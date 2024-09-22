import java.util.*;

class Solution {
    
    int count;
    
    class Node {
        int id;
        int y;
        int x;
        Node left;
        Node right;
        
        Node (int id, int y, int x) {
            this.id = id;
            this.y = y;
            this.x = x;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][1], nodeinfo[i][0]));
        }
        Collections.sort(nodes, (i, j) -> {
            if (i.y == j.y) return Integer.compare(i.x, j.x);
            return Integer.compare(j.y, i.y);
        });
        
        Node root = null;        
        for (Node newNode : nodes) {
            root = insertNode(root, newNode);
        }

        preOrder(root, answer);
        count = 0;
        postOrder(root, answer);
        
        return answer;
    }
    
    void preOrder(Node root, int[][] answer) {
        if (root == null) return;
        answer[0][count++] = root.id;
        preOrder(root.left, answer);
        preOrder(root.right, answer);
    } 
    
    void postOrder(Node root, int[][] answer) {
        if (root == null) return;
        postOrder(root.left, answer);
        postOrder(root.right, answer);
        answer[1][count++] = root.id;
    }
    
    Node insertNode(Node root, Node newNode) {
        if (root == null) return newNode;

        if (root.x > newNode.x) {
            root.left = insertNode(root.left, newNode);
        } else if (root.x < newNode.x) {
            root.right = insertNode(root.right, newNode);
        }

        return root;
    }
}