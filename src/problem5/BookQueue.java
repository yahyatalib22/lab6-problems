package problem5;

import java.util.LinkedList;

public class BookQueue {
    private final LinkedList<Book> queue = new LinkedList<>();

    public void enqueue(Book book) {
        queue.addLast(book);
    }

    public Book dequeue() {
        return queue.isEmpty() ? null : queue.removeFirst();
    }

    public Book peek() {
        return queue.isEmpty() ? null : queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        for (Book book : queue) {
            System.out.println(" - " + book);
        }
    }
}
