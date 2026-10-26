package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;
    private static final int OPERATIONS = 10_000;

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random(42);
        long start = System.nanoTime();
        for (int i = 0; i < OPERATIONS; i++) {
            int index = list.size() / 4 + random.nextInt(list.size() / 2);
            list.add(index, -i);
            list.remove(index);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        if (list instanceof LinkedList) {
            LinkedList<Integer> linked = (LinkedList<Integer>) list;
            for (int i = 0; i < OPERATIONS; i++) {
                linked.addFirst(-i);
                linked.addLast(-i);
            }
            for (int i = 0; i < OPERATIONS; i++) {
                linked.removeFirst();
                linked.removeLast();
            }
        } else {
            for (int i = 0; i < OPERATIONS; i++) {
                list.add(0, -i);
                list.add(-i);
            }
            for (int i = 0; i < OPERATIONS; i++) {
                list.remove(0);
                list.remove(list.size() - 1);
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random(42);
        long start = System.nanoTime();

        long sum = 0;
        for (int i = 0; i < OPERATIONS; i++) {
            sum += list.get(random.nextInt(list.size()));
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
        System.out.println("Sample sum: " + sum);
    }
}

