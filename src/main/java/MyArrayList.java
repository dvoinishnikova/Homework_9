public class MyArrayList {
    private Object[] myArray = new Object[10];
    private int size = 0;
    public void add(Object value) {
        myArray[size] = value;
        size++;
    }
    public void remove(int index) {
        myArray[index] = null;
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
