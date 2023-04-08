public class MyArrayList<E> {
    private Object[] myArray = new Object[10];
    private int size = 0;
    public void add(E value) {
        myArray[size] = value;
        size++;
    }
    public void remove(int index) {
        for (int i = index; i < size - 1; i++)
            myArray[i] = myArray[i + 1];
        myArray[size - 1] = null;
        size--;
    }
    public void clear() {
        for (int i = 0; i < size; i++)
            myArray[i] = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(int index) {
        return myArray[index];
    }
}
