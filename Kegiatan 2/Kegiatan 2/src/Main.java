import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== TO DO LIST ===");
            System.out.println("--- Menu ---");
            System.out.println("1. Tambah data (Enqueue)");
            System.out.println("2. Delete data (Dequeue)");
            System.out.println("3. Tugas pertama (Peek)");
            System.out.println("4. Cek jumlah data (Size)");
            System.out.println("5. Exit");
            System.out.println("--- --- ---");
            System.out.print("\nSelect: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Input to do list: ");
                    scanner.nextLine(); // consume newline character
                    String data = scanner.nextLine();
                    queue.enqueue(data);
                    System.out.println("Data \"" + data + "\" telah ditambahkan ke dalam queue");
                    break;

                case 2:
                    try {
                        String dequeuedData = queue.dequeue();
                        System.out.println("Data \"" + dequeuedData + "\" telah dihapus dari queue");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        String peekedData = queue.peek();
                        System.out.println("Lakukan \"" + peekedData + "\" sesuai dengan urutan queue.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Jumlah to do list pada queue: " + queue.size());
                    if (!queue.isEmpty()) {
                        System.out.println("Hal yang harus dilakukan: " + queue.toString());
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        }
    }
}

class Queue {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        String data = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return data;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = front;
        while (current != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}