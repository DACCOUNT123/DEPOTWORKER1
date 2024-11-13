import java.util.LinkedList;
import java.util.Queue;

public class QueueofCustomers {
    private Queue<Customer> queue;

    public QueueofCustomers() {
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.offer(customer);
    }

    public Customer removeCustomer() {
        return queue.poll();
    }

    public Customer getNextCustomer() {
        return queue.peek();
    }

    public int getQueueSize() {
        return queue.size();
    }
}
