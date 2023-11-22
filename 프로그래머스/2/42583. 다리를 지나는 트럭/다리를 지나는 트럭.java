import java.util.*;

class Solution {
    
    class Truck implements Comparable<Truck> {
        int weight;
        int position;
        
        Truck(int weight) {
            this.weight = weight;
            this.position = 0;
        }
        
        void foward(int step) {
            this.position += step;
        }
        
        @Override
        public int compareTo(Truck truck) {
            return Integer.compare(this.position, truck.position);
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQueue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            waitQueue.add(new Truck(truck_weights[i]));
        }
        
        int time = 0;
        int curWeight = 0;
        PriorityQueue<Truck> runQueue = new PriorityQueue<>();
        
        while (!waitQueue.isEmpty() || !runQueue.isEmpty()) {               
            if (!runQueue.isEmpty()) {
                Truck truck = runQueue.peek();
                int truckPosition = truck.position;
                int truckWeight = truck.weight;
                
                int elapsedTime = time - truckPosition;
                if (elapsedTime >= bridge_length) {
                    curWeight -= truckWeight;
                    runQueue.poll();
                }
            }
            
            if (!waitQueue.isEmpty() && curWeight + waitQueue.peek().weight <= weight) {
                Truck truck = waitQueue.poll();
                runQueue.add(truck);
                curWeight += truck.weight;
            }
            
            for (Truck truck : waitQueue) {
                int step = 1;
                truck.foward(step);
            }
            time++;
        }
        
        return time;
    }
}
