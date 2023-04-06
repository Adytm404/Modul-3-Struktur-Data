public class Main {
    private static final int MAX_SIZE = 100;
    private static String[] queue = new String[MAX_SIZE];
    private static int front = -1;
    private static int rear = -1;

    private static boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    private static boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    private static void enqueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            front++;
            rear++;
            queue[rear] = item;
        } else {
            rear++;
            queue[rear] = item;
        }
    }

    private static String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return "";
        } else if (front == rear) {
            String item = queue[front];
            front = -1;
            rear = -1;
            return item;
        } else {
            String item = queue[front];
            front++;
            return item;
        }
    }

    private static String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return "";
        } else {
            return queue[front];
        }
    }

    public void queueExample() {
        enqueue("Java");
        enqueue("DotNet");
        enqueue("PHP");
        enqueue("HTML");

        System.out.println("Remove: " + dequeue());
        System.out.println("Element: " + peek());
        System.out.println("Poll: " + dequeue());
        System.out.println("Peek: " + peek());
    }

    public static void main(String[] args) {
        new Main().queueExample();
    }
}