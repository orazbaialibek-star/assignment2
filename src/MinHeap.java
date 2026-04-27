public class MinHeap implements IntQueue{
    IntArray arr = new IntArray();

    @Override
    public boolean empty() {
        return arr.isEmpty();
    }

    @Override
    public void add(int item) {
        arr.add(item);
        for (int j = arr.size() - 1; j >= 0; j--){
            Compare(j);
        }
    }

    @Override
    public int peek() {
        return arr.get(0);
    }

    @Override
    public int remove() {
        return arr.remove(arr.size() - 1);
    }

    public void Compare(int i){
        int child = arr.get(i);
        int parent = arr.get((i-1)/2);
        if (parent < child) return;

        if (parent > child) {
            int j = parent;
            arr.set((i-1)/2, child);
            arr.set(i, j);
            Compare(i - 1);
        }
    }

    @Override
    public String toString(){
        return arr.toString();
    }

    ///  main method to test the class.
    static void main() {
        // test the MinHeap class by using it to sort an array in descending order
        MinHeap min = new MinHeap();
        min.add(12);
        min.add(5);
        min.add(6);
        min.add(1);

        System.out.println(min);
    }
}