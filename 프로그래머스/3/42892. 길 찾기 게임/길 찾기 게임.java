import java.util.*;

class Solution {
    
    class Position {
        int value;
        int y;
        int x;
        
        Position(int value, int x, int y) {
            this.value = value;
            this.y = y;
            this.x = x;
        }
    }
    
    class Node {
        int value;
        int x;
        int y;
        Node left;
        Node right;
        
        Node(){}
        
        Node (int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
        
        void setValue(int value) {
            this.value = value;
        }
        
        void setChild(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        List<Position> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Position(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodes, (i, j) -> {
            if (i.y == j.y) {
                return Integer.compare(i.x, j.x);
            }
            return Integer.compare(j.y, i.y);
        });
        
        
        Node root = new Node(nodes.get(0).value, nodes.get(0).x, nodes.get(0).y);
        
        for (int i = 1; i < nodes.size(); i++) {
            setTree(root, new Node(nodes.get(i).value, nodes.get(i).x, nodes.get(i).y));
        }

        int[][] answer = new int[2][nodeinfo.length]; // pre, post
        preOrder(root, answer);
        count = 0;
        postOrder(root, answer);
        
        return answer;
    }
            static int count = 0;
    
    private void setTree(Node root, Node child) {
        if (root.x > child.x) {
            if (root.left != null) {
                setTree(root.left, child);
            } else {
                root.left = child;
            }
        }
        
        if (root.x < child.x) {
            if (root.right != null) {
                setTree(root.right, child);
            } else {
                root.right = child;
            }
        }
    }
    
    private void preOrder (Node root, int[][] answer) {
        answer[0][count++] = root.value;
        if (root.left != null) {
            preOrder(root.left, answer);
        }
        if (root.right != null) {
            preOrder(root.right, answer);
        }
    }
    
    private void postOrder (Node root, int[][] answer) {
        if (root.left != null) {
            postOrder(root.left, answer);
        }
        if (root.right != null) {
            postOrder(root.right, answer);
        }
        answer[1][count++] = root.value;
    }
}