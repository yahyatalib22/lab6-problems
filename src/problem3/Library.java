package problem3;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private final int capacity;
    private final ArrayList<Document> documents;

    public Library(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public void displayDocuments() {
        if (documents.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        for (Document doc : documents) {
            System.out.println(doc);
        }
    }

    public boolean add(Document doc) {
        if (doc == null || documents.size() >= capacity || documents.contains(doc)) {
            return false;
        }
        return documents.add(doc);
    }

    public boolean delete(Document doc) {
        if (doc == null) {
            return false;
        }
        Iterator<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNumEnreg() == doc.getNumEnreg()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnrg) {
        for (Document doc : documents) {
            if (doc.getNumEnreg() == numEnrg) {
                return doc;
            }
        }
        return null;
    }

    public void displayAuthors() {
        boolean found = false;
        for (Document doc : documents) {
            if (doc instanceof Book) {
                System.out.println(((Book) doc).getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No authors in the library.");
        }
    }

    @Override
    public String toString() {
        return "Library (" + documents.size() + "/" + capacity + " documents)";
    }
}
