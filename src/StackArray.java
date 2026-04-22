public class StackArray implements IntStack{
    IntArray arr = new IntArray();

    @Override
    public boolean empty() {
        return arr.isEmpty();
    }

    @Override
    public int peek() {
        return arr.get(arr.size() - 1);
    }

    @Override
    public int pop() {
        return arr.removeLast();
    }

    @Override
    public void push(int item) {
        arr.add(item);
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < arr.size(); i++) {
            s += arr.get(i);
            if (i < arr.size() - 1) s += ", ";
        }
        return s + "]";
    }

    static void main() {
        StackArray stack = new StackArray();
        stack.push(5);
        stack.push(67);
        stack.push(52);

        System.out.println(stack);
    }
}
