import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("=== Select Menu ===");
            System.out.println("1. Input String");
            System.out.println("2. Exit");
            System.out.print("\nSelect: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan string: ");
                    scanner.nextLine();
                    input = scanner.nextLine();

                    Stack stack = new Stack(input.length());


                    for (int i = 0; i < input.length(); i++) {
                        char c = input.charAt(i);
                        stack.push(c);
                    }


                    StringBuilder reversed = new StringBuilder();
                    while (!stack.isEmpty()) {
                        char c = stack.pop();
                        reversed.append(c);
                    }

                    System.out.println("Hasil pembalikan: " + reversed.toString() + "\n");
                    break;

                case 2:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        }
    }
}

class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        stackArray[++top] = c;
    }

    public char pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}