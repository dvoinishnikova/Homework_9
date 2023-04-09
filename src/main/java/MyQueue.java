public class MyQueue<E>{
    private E[] elements = (E[]) new Object[10];
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public void add(E value) {
        tail = (tail + 1) % elements.length;
        elements[tail] = value;
        size++;
    }
    public void clear() {
        elements = (E[]) new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }
    public int size() {
        return size;
    }

    public E peek() {
        return elements[head];
    }

    public E poll() {
        E value = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return value;
    }
}
