package iterator;

import java.util.Iterator;

interface Sequence {
    Iterator<Integer> iterator();
}

class FibonacciSequence implements Sequence {
    private final int limit;

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}

class FibonacciIterator implements Iterator<Integer> {
    private int count = 0;
    private final int limit;
    private int prev = 1;
    private int curr = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        count++;
        if (count == 1) {
            return prev;  // 1
        } else if (count == 2) {
            return curr;  // 1
        } else {
            int nextValue = prev + curr;
            prev = curr;
            curr = nextValue;
            return nextValue;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence(10);

        for (int num : (Iterable<Integer>) sequence::iterator) {
            System.out.print(num + " ");
        }
    }
}


