import java.util.*;

class Solution {
    
    class Truck implements Comparable<Truck> {
        int time;
        int weight;
        
        Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
        
        void setTime(int time) {
            this.time = time;
        }
        
        @Override
        public int compareTo(Truck truck) {
            return Integer.compare(this.time, truck.time);
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQueue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            waitQueue.add(new Truck(0, truck_weights[i]));
        }
        
        int time = 1;
        int curWeight = 0;
        PriorityQueue<Truck> runQueue = new PriorityQueue<>();
        
        while (!waitQueue.isEmpty() || !runQueue.isEmpty()) {               
            if (!runQueue.isEmpty()) {
                Truck truck = runQueue.peek();
                int initTime = truck.time;
                int truckWeight = truck.weight;
                int elapsedTime = time - initTime;

                if (elapsedTime >= bridge_length) {
                    curWeight -= truckWeight;
                    runQueue.poll();
                }
            }
            
            if (!waitQueue.isEmpty() && curWeight + waitQueue.peek().weight <= weight) {
                Truck truck = waitQueue.poll();
                truck.setTime(time);
                runQueue.add(truck);
                curWeight += truck.weight;
            }
            time++;
        }
        
        return time - 1;
    }
}
