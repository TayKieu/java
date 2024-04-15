package bai9DSA.baitap1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;


    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            this.ensureCapacity();
        }
        size++;
        for (int i = size; i >= index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E remove(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return (E) elements;
    }
    public int getSize() {
        return this.size;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i])) {
                return i;
            }
        return -1;
    }

    public boolean add(E e) {
        if (elements.length == size) {
            this.ensureCapacity();
        }
        elements[size++] = e;
        return true;
    }

    public E getElement(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("index: " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
