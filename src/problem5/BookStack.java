package problem5;

import java.util.LinkedList;

public class BookStack {
    private final LinkedList<Book> stack = new LinkedList<>();

    public void push(Book book) {
        stack.addFirst(book);
    }

    public Book pop() {
        return stack.isEmpty() ? null : stack.removeFirst();
    }

    public Book peek() {
        return stack.isEmpty() ? null : stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book book : stack) {
            System.out.println(" - " + book);
        }
    }
}
