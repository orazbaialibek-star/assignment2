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
            CompareChiPar(j);
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
        arr.removeLast();
        for (int j = 0; j <= arr.size()-1; j++){
            CompareChilds(j);
        }
        return res;
    }

    public void CompareChiPar(int i){
        int child = arr.get(i);
        int parent = arr.get((i-1)/2);

        if (parent > child) {
            int j = parent;
            arr.set((i-1)/2, child);
            arr.set(i, j);
        }
    }

    private void CompareChilds(int i) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;

        if (left < arr.size() && arr.get(left) < arr.get(smallest))
            smallest = left;
        if (right < arr.size() && arr.get(right) < arr.get(smallest))
            smallest = right;

        int temp = arr.get(i);
        arr.set(i, arr.get(smallest));
        arr.set(smallest, temp);
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
        min.add(2);
        min.add(10);
        min.add(8);

        System.out.println(min);

        min.remove();

        System.out.println(min);
    }
}