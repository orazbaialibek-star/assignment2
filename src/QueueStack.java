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
        if (sOut.empty()) {
            while (!sIn.empty()) {
                sOut.push(sIn.pop());
            }
        }
        return sOut.pop();
    }

    public String stringIn(){
        return sIn.toString();
    }

    public String stringOut(){
        return sOut.toString();
    }

    public void check(QueueStack qs){
        System.out.println(qs.stringIn());
        System.out.println(qs.stringOut());
    }

    static void main(){
        QueueStack qs = new QueueStack();

        qs.add(41);
        qs.add(49);
        qs.add(32);
        qs.add(76);

        qs.check(qs);
        System.out.println(qs.peek());
        System.out.println(qs.remove());
        qs.check(qs);

        qs.add(67);

        qs.check(qs);
        System.out.println(qs.remove());
        qs.check(qs);
    }
}
