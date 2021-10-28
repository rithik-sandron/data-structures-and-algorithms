import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        long start = System.nanoTime() / 1000000;
        Array<Integer> a = new Array<>(10);
        a.push(1); // push
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);
        a.push(7);
        a.push(8);
        a.push(9);
        a.push(10);
        a.push(11);
        a.pop(); // pop
        System.out.println("capacity: " + a.getCapacity());
        System.out.println("size: " + a.size());
        System.out.println("array: " + a.toString());
        
        a.reverse();
        System.out.println(a.toString());

        Iterator<Integer> iterator = a.iterator(); // iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        System.out.println("capacity: " + queue.getCapacity());
        System.out.println("size: " + queue.size());
        System.out.println("array: " + queue.toString());

        System.out.println("program ran for " + ((System.nanoTime() / 1000000) - start) + " milli seconds");
    }
}
