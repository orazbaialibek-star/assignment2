public class StackQueue implements IntStack{
    QueueList q1 = new QueueList();
    QueueList q2 = new QueueList();

    @Override
    public boolean empty() {
        return q1.empty();
    }

    @Override
    public int peek() {
        return q1.peek();
    }

    @Override
    public int pop() {
        return q1.remove();
    }

    @Override
    public void push(int item) {
        q2.add(item);

        while (!q1.empty()) {
            q2.add(q1.remove());
        }

        QueueList temp = q1;
        q1 = q2;
        q2 = temp;
    }

    static void main() {

    }
}
