package edu.remsely.java_patterns.pr8;


import java.util.NoSuchElementException;

interface Iterator<T> {
    boolean hasNext();

    T next();
}

class SringArrayIterator implements Iterator<String> {
    private final String[] array;
    private int pos = 0;

    public SringArrayIterator(String[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return pos < array.length;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[pos++];
    }
}

class StringArrayCollection {
    private final String[] array;

    public StringArrayCollection(String[] array) {
        this.array = array;
    }

    public Iterator<String> iterator() {
        return new SringArrayIterator(array);
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        String[] data = {"one", "two", "three", "four", "five"};
        StringArrayCollection collection = new StringArrayCollection(data);
        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
