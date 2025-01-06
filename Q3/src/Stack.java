import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Stack class implementing Iterable interface
public class Stack<T> implements Iterable<T> {
    private ArrayList<T> stack; // ArrayList to store stack elements

    // Constructor for Stack
    public Stack() {
        this.stack = new ArrayList<>();
    }

    // Push method to add an item to the stack
    public void push(T item) {
        stack.add(item);
    }

    // Pop method to remove and return the top item of the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    // Peek method to view the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Method to get the size of the stack
    public int getSize() {
        return stack.size();
    }

    // Iterator implementation
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int currentIndex = stack.size() - 1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return stack.get(currentIndex--);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }
}