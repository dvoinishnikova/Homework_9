public class MyHashMap {
    private Node[] buckets = new Node[16];
    private int size = 0;
    private class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public void put(Object key, Object value) {
        int bucketIndex = key.hashCode() % buckets.length;
        Node current = buckets[bucketIndex];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
        size++;
    }
    public void remove(Object key) {
        int bucketIndex = key.hashCode() % buckets.length;
        Node current = buckets[bucketIndex];
        Node previous = null;

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
        buckets = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }


    public Object get(Object key) {
        int bucketIndex = key.hashCode() % buckets.length;
        Node current = buckets[bucketIndex];

        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }

        return null;
    }



}
