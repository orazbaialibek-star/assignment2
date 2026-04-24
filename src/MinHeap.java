public class MinHeap implements IntQueue{
    IntArray arr = new IntArray();

    @Override
    public boolean empty() {
        return arr.isEmpty();
    }

    @Override
    public void add(int item) {
        arr.add(item);
    }

    @Override
    public int peek() {
        return arr.get(0);
    }

    @Override
    public int remove() {
        return 0;
    }

    ///  main method to test the class.
    static void main() {
        // test the MinHeap class by using it to sort an array in descending order

    }
}
