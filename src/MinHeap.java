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
        int res = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        for (int j = arr.size() - 1; j >= 0; j--){
            Compare(j);
        }
        return res;
    }

    public void Compare(int i){
        int child = arr.get(i);
        int parent = arr.get((i-1)/2);
        if (parent < child) return;

        if (parent > child) {
            int j = parent;
            arr.set((i-1)/2, child);
            arr.set(i, j);
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
        min.add(5);
        min.add(3);
        min.add(6);
        min.add(4);

        System.out.println(min);

        min.remove();

        System.out.println(min);
    }
}