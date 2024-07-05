class MyHashMap {

    Integer[] map = new Integer[1000001];

    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        if (map[key] == null) return -1;
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */