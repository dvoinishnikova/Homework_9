public class MyQueue {
    private Object[] elements = new Object[10];
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public void add(Object value) {
        tail = (tail + 1) % elements.length;
        elements[tail] = value;
        size++;
    }
    public void clear() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }
    public int size() {
        return size;
    }

    public Object peek() {
        return elements[head];
    }

    public Object poll() {
        Object value = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return value;
    }
}
