import java.util.*;

class Solution {    
    public int solution(int[] priorities, int location) {
        int[] prList = new int[priorities.length];
        
        
        int[] sortedPriorities = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sortedPriorities);
        
        int rank = priorities.length - 1;
        while (rank >= 0) {
            for (int i = 0; i < priorities.length; i++) {
                if (prList[i] != 0) {
                    continue;
                }
                
                int prValue = sortedPriorities[rank];
                if (prValue == priorities[i]) {
                    prList[i] = priorities.length - rank;
                    rank--;
                }
            }
        }

        return prList[location];
    }
}
/*
import java.util.*;

class Solution {
    class Process {
        int priority;
        int location;
        
        Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
        
        public int getPriority() {
            return priority;
        }
        
        public int getLocation() {
            return location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int[] prList = new int[priorities.length + 1];
        
        int answer = 0;
        List<Process> processes = new ArrayList();
        List<Process> sortedProcesses = new ArrayList();
        for (int i = 0; i < priorities.length; i++) {
            processes.add(new Process(priorities[i], i));
            sortedProcesses.add(new Process(priorities[i], i));
        }
        sortedProcesses.sort((p1, p2) -> Integer.compare(p2.getPriority(), p1.getPriority()));
        
        int rank = 0;
        while (rank < priorities.length) {
            for (int i = 0; i < priorities.length; i++) {
                if (prList[i] != 0) {
                    continue;
                }
                
                int prValue = sortedProcesses.get(rank).getPriority();
                if (prValue == processes.get(i).getPriority()) {
                    prList[i] = ++rank;
                }
            }
        }

        return prList[location];
    }
}
*/