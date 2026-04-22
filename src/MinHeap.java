public class MinHeap implements IntQueue{
    IntArray arr = new IntArray();

    @Override
    public boolean empty() {
        return arr.isEmpty();
    }

    @Override
    public void add(int item) {
        arr.add(item);

        int i = arr.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (arr.get(i) < arr.get(parent)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(parent));
                arr.set(parent, temp);
                i = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public int peek() {
        return arr.get(0);
    }

    @Override
    public int remove() {
        int min = arr.get(0);

        arr.set(0, arr.get(arr.size() - 1));
        arr.removeLast();

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < arr.size() && arr.get(left) < arr.get(smallest)) {
                smallest = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) break;

            int temp = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, temp);

            i = smallest;
        }

        return min;
    }

    ///  main method to test the class.
    static void main() {
        // test the MinHeap class by using it to sort an array in descending order
        int[] arr = {5, 1, 9, 3};

        MinHeap h = new MinHeap();

        h.add(50);
        h.add(4);
        h.add(67);
    }
}
