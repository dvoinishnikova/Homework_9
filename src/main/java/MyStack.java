public class MyStack<E> {
    private E[] stack = (E[]) new Object[10];
    private int top = -1;
    public void push(E value) {
        top++;
        stack[top] = value;
    }
    public void remove(int index) {
        for (int i = index; i < top; i++)
            stack[i] = stack[i + 1];
        top--;
    }
    public void clear() {
        top = -1;
    }
    public int size() {
        return top + 1;
    }
    public E peek() {
        return stack[top];
    }
    public E pop() {
        E result = stack[top];
        stack[top] = null;
        top--;
        return result;
    }
}
