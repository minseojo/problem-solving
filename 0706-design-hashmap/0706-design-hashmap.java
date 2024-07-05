class MyHashMap {

    static final int MAX_SIZE = 1_000_000;

    static class Node {
        int key;
        int val;
        Node next;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] nodes = new Node[MAX_SIZE];

    public void put(int key, int value) {
        int index = hash(key);

        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }

        // 인덱스에 노드가 존재하면 연결리스트로 충돌 해결 (체이닝 방식)
        Node node = nodes[index];
        while (node != null) {
            // 동일한 키가 있으면 값 업데이트 후 리턴
            if (node.key == key) {
                node.val = value; 
                return;
            }
            node = node.next;
        }
        node = new Node(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);

        if (nodes[index] == null) {
            return -1;
        }

        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);

        if (nodes[index] == null) {
            return;
        }

        Node node = nodes[index];
        if (node.key == key) {
            if (node.next == null) {
                nodes[index] = null;
            } else {
                nodes[index] = node.next;
            }
        }

        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    private int hash(int key) {
        return (key * 31) % MAX_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */