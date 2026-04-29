import java.util.Scanner;

/// A resizable array of integers.
/// It grows internally when items are added and shrinks when items are removed.
public class IntArray {
    /// Internal int[] representation of IntArray.
    private int[] array;
    /// Number of elements in the array.
    private int size;

    ///  Initializes the array with a default size and capacity (e.g. size is 0 and capacity is 4).
    public IntArray(){
        array = new int[4];
        size = 0;
    }

    /// Initializes the array by adding the items from an int[] array.
    public IntArray(int []items){
        this();
        for (int item : items) {
            add(item);
        }
    }

    // Getter for size.
    public int size() {
        return size;
    }

    ///  Returns the item at the index position in the array.
    public int get(int index){
        return array[index];
    }

    ///  Updates the item at index position and returns the old item.
    public int set(int index, int item){
        int old = array[index];
        array[index] = item;
        return old;
    }

    ///  Adds a new item to the array at the end position.
    public void add(int item){
        if (size == array.length) {
            int[] newArr = new int[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[size] = item;
        size++;
    }

    ///  Inserts a new item to the array at the index position.
    public void addAt(int index, int item){
        if (size == array.length) {
            int[] newArr = new int[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = item;
        size++;
    }

    /// Removes the item at index i and returns it.
    public int remove(int index){
        int num = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return num;
    }

    /// Removes the first item and returns it.
    public int removeFirst(){
        return remove(0);
    }

    /// Removes the last item and returns it.
    public int removeLast(){
        return remove(size-1);
    }

    /// Removes the first occurrence of an item and returns whether the item was found.
    public boolean removeItem(int item){
        for (int i = 0; i < size; i++){
            if (array[i] == item){
                remove(i);
                return true;
            }
        }
        return false;
    }

    /// Returns the index of the first occurrence of an item or -1.
    public int indexOf(int item){
        for (int i = 0; i < size; i++){
            if (array[i] == item){
                return i;
            }
        }
        return -1;
    }

    /// Returns true if there are no elements in the array.
    public boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    /// Returns a string representation of the array, e.g. an array that contains 1,2 and 3 would look as "[1, 2, 3]".
    @Override
    public String toString() {
        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.print(array[size-1]);
        return "]";
    }

    public static Scanner sc = new Scanner(System.in);

    ///  main method to test the class.
    static void main(String[] args) {
        IntArray a = new IntArray();
        a.add(5);
        a.add(4);
        a.add(12);
        a.add(3);
        System.out.println(a.size());
        System.out.println(a.get(0));
        System.out.println(a);
        System.out.println(a.set(0,1));
        System.out.println(a);
        a.addAt(3,67);
        System.out.println(a);
        a.remove(1);
        System.out.println(a);
        a.removeItem(67);
        System.out.println(a);
        System.out.println(a.indexOf(3));
    }
}
