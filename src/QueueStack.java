public class QueueStack implements IntQueue{
    StackArray sIn = new StackArray();
    StackArray sOut = new StackArray();

    @Override
    public boolean empty() {
        return sIn.empty() || sOut.empty();
    }

    @Override
    public void add(int item) {
        sIn.push(item);
    }

    @Override
    public int peek() {
        return sIn.peek();
    }

    @Override
    public int remove() {
        return sIn.pop();
    }
}
