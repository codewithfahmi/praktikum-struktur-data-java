import algorithm.Queue;
import algorithm.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack<>(5);
        // Praktik 1
        stack.push("Buku A");
        stack.push("Buku B");
        stack.push("Buku C");
        stack.push("Buku D");
        stack.dump();

        System.out.println("\n");

        // Praktik 2
        stack.push("Buku E");
        stack.push("Buku F");
        stack.push("Buku G");
        stack.dump();
        
        System.out.println("\n");

        // Praktik 3
        System.out.println("POP: " + stack.pop());
        stack.dump();

        System.out.println("\n");

        // Praktik 4
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        stack.dump();

        System.out.println("\n");

        // Praktik 5
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        stack.dump();

        System.out.println("\n");

        // Praktik 6
        Queue<String> queue = new Queue<>(5);
        queue.enqueue("Mobil A");
        queue.enqueue("Mobil B");
        queue.enqueue("Mobil C");
        queue.dump();

        System.out.println("\n");

        // Praktik 7
        queue.enqueue("Mobil D");
        queue.enqueue("Mobil E");
        queue.enqueue("Mobil F");
        queue.dump();

        System.out.println("\n");

        // Praktik 8
        System.out.println("deQueue: " + queue.dequeue());
        queue.dump();

        System.out.println("\n");

        // Praktik 9
        System.out.println("deQueue: " + queue.dequeue());
        System.out.println("deQueue: " + queue.dequeue());
        System.out.println("deQueue: " + queue.dequeue());
        queue.dump();

        System.out.println("\n");
        
        // Praktik 10
        System.out.println("deQueue: " + queue.dequeue());
        System.out.println("deQueue: " + queue.dequeue());
        queue.dump();
    }
}
