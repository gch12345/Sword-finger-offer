package nowCoder;

import java.util.LinkedList;
import java.util.Queue;

public class TowQueueAchieveStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public void push(int num) {
        queue1.add(num);
    }
    public int pop() {
        if (queue1.size() == 1) {
            return queue1.poll();
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        return queue1.poll();
    }
}
