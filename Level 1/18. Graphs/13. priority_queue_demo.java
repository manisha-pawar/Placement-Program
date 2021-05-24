import java.util.*;

public class Main {
    public static class Car implements Comparable<Car>{
        float speed;
        String model;
        
        Car() {
            
        }
        
        Car(float speed,String model) {
            this.speed = speed;
            this.model = model;
        }
        
        //+ve value -> this > o
        //-ve value -> this < o
        //0 -> this == o
        
        public int compareTo(Car o) {
            float gap = this.speed - o.speed;
            
            if(gap < 0) {
                return -1;
            }
            else if(gap > 0){
                return 1;
            }
            else {
                return 0;
            }
        }
        
    }
    public static void main(String[]args) {
        //PriorityQueue<Integer>pq = new PriorityQueue<>(); //smallest value has highest priority
        // PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder()); //highest value has highest priority

        
        // pq.add(10);
        // pq.add(15);
        // pq.add(20);
        // pq.add(5);
        // pq.add(7);
        // pq.add(18);
        
        // while(pq.size() > 0) {
        //     int top = pq.peek();
        //     pq.remove();
        //     System.out.print(top + " ");
        // }
        
        PriorityQueue<Car>pq = new PriorityQueue<>(); //larger one has highest priority
        
        pq.add(new Car(9.48f,"abc"));
        pq.add(new Car(9.38f,"xyz"));
        pq.add(new Car(5.67f,"def"));
        
        
        while(pq.size() > 0) {
            Car top = pq.peek();
            pq.remove();
            System.out.println(top.speed + " " + top.model);
        }
    }
}