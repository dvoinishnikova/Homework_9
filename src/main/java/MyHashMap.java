public class MyHashMap<K, V> {
    private Node<K, V>[] buckets = new Node[10];
    private int size = 0;
    private int capacity = 10;
    private static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public void put(K key, V value) {
        int bucketIndex = key.hashCode() % buckets.length;
        Node<K, V> current = buckets[bucketIndex];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
        size++;

        if (size > capacity)
            resize();
    }
    private void resize() {
        Node<K, V>[] newBuckets = new Node[capacity * 2];
        for (Node<K, V> bucket : buckets) {
            while (bucket != null) {
                K key = bucket.key;
                V value = bucket.value;
                int bucketIndex = key.hashCode() % newBuckets.length;

                Node<K, V> newNode = new Node<>(key, value);
                newNode.next = newBuckets[bucketIndex];
                newBuckets[bucketIndex] = newNode;

                bucket = bucket.next;
            }
        }
        buckets = newBuckets;
        capacity *= 2;
    }

    public void remove(K key) {
        int bucketIndex = key.hashCode() % buckets.length;
        Node<K, V> current = buckets[bucketIndex];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null)
                    buckets[bucketIndex] = current.next;
                else
                    previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
    public void clear() {
        buckets = new Node[10];
        size = 0;
    }

    public int size() {
        return size;
    }


    public V get(K key) {
        int bucketIndex = key.hashCode() % buckets.length;
        Node<K, V> current = buckets[bucketIndex];

        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }

        return null;
    }



}