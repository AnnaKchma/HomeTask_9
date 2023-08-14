package org.example;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        checkIndex(index);

        Node<T> nodeToRemove = getNode(index);

        if (nodeToRemove == head) {
            head = nodeToRemove.next;
        } else {
            nodeToRemove.previous.next = nodeToRemove.next;
        }

        if (nodeToRemove == tail) {
            tail = nodeToRemove.previous;
        } else {
            nodeToRemove.next.previous = nodeToRemove.previous;
        }

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);

        Node<T> node = getNode(index);
        return node.value;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node<T> {
        private final T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
}
