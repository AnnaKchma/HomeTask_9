package org.example;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (addToBucket(buckets, index, newNode)) {
            size++;
        }

        if (size >= buckets.length) {
            resizeBuckets();
        }
    }

    public void remove(K key) {
        int index = getIndex(key);
        size -= removeFromBucket(buckets, index, key);
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        return getValueFromBucket(buckets, index, key);
    }

    private int getIndex(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    private boolean addToBucket(Node<K, V>[] buckets, int index, Node<K, V> newNode) {
        if (buckets[index] == null) {
            buckets[index] = newNode;
            return true;
        } else {
            Node<K, V> current = buckets[index];
            Node<K, V> prev = null;

            while (current != null) {
                if (keysEqual(current.key, newNode.key)) {
                    current.value = newNode.value;
                    return false;
                }
                prev = current;
                current = current.next;
            }

            prev.next = newNode;
            return true;
        }
    }

    private int removeFromBucket(Node<K, V>[] buckets, int index, K key) {
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;
        int count = 0;

        while (current != null) {
            if (keysEqual(current.key, key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                count++;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return count;
    }

    private V getValueFromBucket(Node<K, V>[] buckets, int index, K key) {
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    private void resizeBuckets() {
        int newCapacity = buckets.length * 2;
        Node<K, V>[] newBuckets = new Node[newCapacity];

        for (Node<K, V> node : buckets) {
            while (node != null) {
                int newIndex = getIndex(node.key);
                Node<K, V> newNode = new Node<>(node.key, node.value);
                newNode.next = newBuckets[newIndex];
                newBuckets[newIndex] = newNode;
                node = node.next;
            }
        }

        buckets = newBuckets;
    }

    private boolean keysEqual(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

