public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.getSize()); // Output: 3

        // Iterate over the stack
        for (int item : stack) {
            System.out.println(item); // Output: 30, 20, 10
        }

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Peek: " + stack.peek());  // Output: 20
        System.out.println("Popped: " + stack.pop()); // Output: 20
        System.out.println("Is empty: " + stack.isEmpty()); // Output: false

        System.out.println("Popped: " + stack.pop()); // Output: 10
        System.out.println("Is empty: " + stack.isEmpty()); // Output: true
    }
}