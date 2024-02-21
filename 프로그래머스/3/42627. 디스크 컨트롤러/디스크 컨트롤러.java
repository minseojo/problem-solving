import java.util.*;

class Solution {
    
    class Data {
        int requestTime;
        int takenTime;
        
        Data(int requestTime, int takenTime) {
            this.requestTime = requestTime;
            this.takenTime = takenTime;
        }
    }
    
    // 현재ms 시점에 가장 적게 걸리는 작업을 넣음
    
    public int solution(int[][] jobs) {        
        boolean[] visited = new boolean[551];
        int answer = 0;
        int time = 0;
        for (int i = 0; i < jobs.length; i++) {
            int requestTime = time;
            int takenTime = Integer.MAX_VALUE;
            int pick = -1;
            int minRequestTime = Integer.MAX_VALUE;
            for (int j = 0; j < jobs.length; j++) {
                int[] job = jobs[j];
                if (!visited[j]) {
                    if (requestTime >= job[0] && takenTime > job[1]) {
                        takenTime = job[1];
                        pick = j;
                    }
                    minRequestTime = Math.min(minRequestTime, job[0]);
                }
            }
            
            if (pick != -1) {
                visited[pick] = true;
                answer += (time + jobs[pick][1] - jobs[pick][0]);
                time += jobs[pick][1];
            } else {
                time = minRequestTime;
                i--;
            }
        }

        return answer / jobs.length;
    }
}

// 정해
/*
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;

        // 소요시간 우선순위 큐
        PriorityQueue<int[]> workQue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 작업 요청 시점 우선순위 큐
        PriorityQueue<int[]> inQue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int[] j : jobs)
            inQue.offer(j);

        // 소요시간 우선순위 큐 또는 작업 요청 시점 우선순위 큐가 비어있지 않을 때
        while(!inQue.isEmpty() || !workQue.isEmpty()){
            // 현재 시간에 수행 가능한 작업을 모두 소요시간 우선순위 큐에 넣음
            while(!inQue.isEmpty() && inQue.peek()[0] <= time){
                workQue.offer(inQue.poll());
            }

            if(workQue.isEmpty()){ // 소요시간 우선순위 큐가 비었다면 현재 시간에 수행 가능항 작업이 없다는 뜻이므로 현재 시간을 최소 요청시간으로 변경
                time = inQue.peek()[0];
            }else{ // 소요시간 우선순위 큐에서 작업시간이 가장 적은 것을 꺼내서 먼저 계산
                int[] j = workQue.poll();
                answer += time + j[1] - j[0];
                time += j[1];
            }
            // 다시 현재 시간을 기준으로 수행 가능한 작업을 소요시간 우선순위 큐에 넣음
        }

        answer /= jobs.length;

        return answer;
    }
}
*/