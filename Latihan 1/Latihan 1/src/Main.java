public class Main {
    private static final int MAX_SIZE = 100;
    private static String[] stack = new String[MAX_SIZE];
    private static int top = -1;

    private static boolean isEmpty() {
        return top == -1;
    }

    private static void push(String item) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack overflow");
        } else {
            top++;
            stack[top] = item;
        }
    }

    private static String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return "";
        } else {
            String item = stack[top];
            top--;
            return item;
        }
    }

    private static String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return "";
        } else {
            return stack[top];
        }
    }

    private static int search(String item) {
        for (int i = top; i >= 0; i--) {
            if (stack[i].equals(item)) {
                return top - i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        push("Aku");
        push("Anak");
        push("Indonesia");

        System.out.println("Next : " + peek());
        push("Raya");
        System.out.println(pop());
        push("!");

        int count = search("Aku");
        while (count != -1 && count > 1){
            pop();
            count--;
        }

        System.out.println(pop());
        System.out.println(isEmpty());
    }
}