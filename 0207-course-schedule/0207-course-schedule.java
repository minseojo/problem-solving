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
        for (Integer finish : courses.keySet()) {
            if (!dfs(finish, takes, courses)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(Integer finish, List<Integer> takes, Map<Integer, List<Integer>> courses) {
        if (takes.contains(finish)) 
            return false;

        if (courses.containsKey(finish)) {
            takes.add(finish);
            for (Integer take : courses.get(finish)) {
                if (!dfs(take, takes, courses)) 
                    return false;
            }
            takes.remove(finish);
        }
        
        return true;
    }
}