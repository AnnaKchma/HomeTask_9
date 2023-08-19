package org.example;

public class MyQueue<T> {
    private Object[] array;
    private int size;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void add(T value) {
        if (size == array.length) {
            resizeArray();
        }
        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) array[front];
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T value = (T) array[front];
        front = (front + 1) % array.length;
        size--;
        return value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }
}