public class MyStack {
    private Object[] stack = new Object[10];
    private int top = -1;
    public void push(Object value) {
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
    public Object peek() {
        return stack[top];
    }
    public Object pop() {
        Object result = stack[top];
        stack[top] = null;
        top--;
        return result;
    }
}
