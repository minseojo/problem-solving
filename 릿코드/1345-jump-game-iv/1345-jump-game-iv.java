class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
    
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(arr[i], value -> new ArrayList()).add(i);
        }
        System.out.println(map.values());
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        int result = 0;
        while(!q.isEmpty()){
            result++;
            int size = q.size();
            while(size-- > 0) {
                int j = q.poll(); 
                if(j-1 >= 0 && map.containsKey(arr[j-1])) {
                    q.offer(j-1);
                }
                if(j+1<n && map.containsKey(arr[j+1])) {
                    if(j+1 == n-1) return result;
                    q.offer(j+1);
                }
                if(map.containsKey(arr[j])){
                    for(int k : map.get(arr[j])) {
                        if(k != j) {
                            if(k == n-1) return result;
                            q.offer(k);
                        }
                    }
                }
                map.remove(arr[j]);
            }
        }
        
        return result;
    }
}