class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courses = new HashMap<>();
        for (int[] p : prerequisites) {
            int from = p[0];
            int to = p[1];
            courses.putIfAbsent(from, new LinkedList<>());
            courses.get(from).add(to);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (Integer finish : courses.keySet()) {
            if (!dfs(finish, takes, taken, courses)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(Integer here, List<Integer> takes, List<Integer> taken, Map<Integer, List<Integer>> courses) {
        if (takes.contains(here)) 
            return false;
            
        if (taken.contains(here)) 
            return true;
        taken.add(here);

        if (courses.containsKey(here)) {
            takes.add(here);
            for (Integer take : courses.get(here)) {
                if (!dfs(take, takes, taken, courses)) 
                    return false;
            }
            takes.remove(here);
        }
        
        return true;
    }
}