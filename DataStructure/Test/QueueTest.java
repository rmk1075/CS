package DataStructure.Test;

import DataStructure.Queue.CustomQueue;

public class QueueTest {
    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.offer(i);
        }
    
        while(queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}
