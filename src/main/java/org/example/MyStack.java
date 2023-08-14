package org.example;

class MyStack<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) array[size - 1];
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        T value = (T) array[--size];
        array[size] = null;
        return value;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}

