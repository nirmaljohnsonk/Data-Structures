@SuppressWarnings("unchecked")
public class DynamicArray<T> {
    private T [] array;
    private int length = 0;     //length user thinks array is, the total elements in the array
    private int capacity;   //Actual array size

    public DynamicArray(){
        this(16);
    }

    public DynamicArray(int capacity){
        if (capacity < 0){throw new IllegalArgumentException("capacity should grater than zero");}
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        return array[index];
    }

    public void set(T element, int index){
        array[index] = element;
    }

    public void add(T element){
        if(length +1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] newArray = array.clone();
            array = (T[]) new Object[capacity];
            array = newArray;
        }
        array[length++] = element;
    }

    public T removeAt(int index){
        if (index < 0 || index > length) throw new IllegalArgumentException("Index not valid");
        T element = array[index];
        T [] newArray = (T[]) new Object[length-1];
        for(int i = 0,j = 0; i< length;i++,j++){
            if( i == index) j--;
            newArray[j] = array[i];
        }
        array = newArray;
        capacity = --length;
        return element;
    }
    public boolean remove(T element){
        for (int i = 0; i<length;i++){
            if(array[i].equals(element)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }
    public int indexOf(T element){
        for(int i=0; i < length; i++){
            if(array[i].equals(element)) return i;
        }
        return -1;
    }

    public boolean contains(T element){
        return indexOf(element) != -1;
    }
}
