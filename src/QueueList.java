public class QueueList implements IntQueue{
    IntList list = new IntList();

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public void add(int item) {
        list.addLast(item);
    }

    @Override
    public int peek() {
        return list.getFirst();
    }

    @Override
    public int remove() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        String s = "[";
        IntList.Node cur = list.head();

        while (cur != null) {
            s += cur.value;
            if (cur.next != null) s += ", ";
            cur = cur.next;
        }

        return s + "]";
    }

    ///  main method to test the class.
    static void main() {
        QueueList q = new QueueList();

        q.add(16);
        q.add(24);
        q.add(302);

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.empty());
    }
}
