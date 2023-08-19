package org.example;

public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            arrayList.add(i);
        }

        // Test MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        for (int i = 1; i <= 1000000; i++) {
            linkedList.add("Item " + i);
        }

        // Test MyQueue
        MyQueue<Double> queue = new MyQueue<>();
        for (int i = 1; i <= 1000000; i++) {
            queue.add((double) i);
        }

        // Test MyStack
        MyStack<Character> stack = new MyStack<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            stack.push(c);
        }

        // Test MyHashMap
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        for (int i = 1; i <= 1000000; i++) {
            hashMap.put("Key" + i, i);
        }

        arrayList.clear();
        linkedList.clear();
        queue.clear();
        stack.clear();
        hashMap.clear();
    }
}
