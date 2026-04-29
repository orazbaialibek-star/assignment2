public class IntList {
    private Node head;
    private int size;

    public IntList(){
        head = null;
        size = 0;
    }

    public Node head(){
        return head;
    }

    /// Returns the number of items in the list.
    public int size(){
        return size;
    }

    /// Returns true if the list has no items.
    boolean isEmpty(){
        return size == 0;
    }

    /// Inserts the specified item at the beginning of this list.
    public void addFirst(int item){
        head = new Node(item, head);
        size++;
    }

    /// Appends the specified item to the end of this list.
    public void addLast(int item){
        if (head == null) {
            head = new Node(item);
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(item);

        size++;
    }

    /// Inserts the specified item at the specified position in this list.
    public void add(int index, int item){
        if (index == 0) {
            addFirst(item);
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = new Node(item, cur.next);
        size++;
    }

    /// Returns the item at the specified position in this list.
    public int get(int index){
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /// Returns the first item in this list.
    public int getFirst(){
        return head.value;
    }

    /// Returns the last item in this list.
    public int getLast(){
        return get(size - 1);
    }

    /// Replaces the item at the specified position in this list with the specified item.
    public int set(int index, int item){
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        int old = cur.value;
        cur.value = item;
        return old;
    }

    /// Returns the index of the first occurrence of the specified item in this list, or -1 if this list does not contain the item.
    public int indexOf(int item){
        Node cur = head;
        int i = 0;

        while (cur != null) {
            if (cur.value == item) return i;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    /// Removes the item at the specified position in this list.
    public int remove(int index){
        if (index == 0){
            int val = head.value;
            head = head.next;
            size--;
            return val;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        int removed = cur.next.value;
        cur.next = cur.next.next;
        size--;
        return removed;
    }

    /// Removes the first occurrence of the specified item from this list, if it is present.
    public boolean removeItem(int item){
        if (head == null) return false;
        if (head.value == item) {
            removeFirst();
            return true;
        }
        for(int i = 0; i <= size; i++){
            int targ = get(i);
            if (targ == item){
                remove(i);
                return true;
            }
        }
        return false;
    }

    /// Removes and returns the first item from this list.
    public int removeFirst(){
        return remove(0);
    }

    /// Reverses the list in place.
    public void reverse(){
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        System.out.print("[");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            if (cur.next != null) System.out.print(", ");
            cur = cur.next;
        }
        return "]";
    }

    // Internal class that represent a list node.
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
        Node(int value, Node next) {
            this.value = value; this.next = next;
        }
    }

    /// main method to test the class.
    static void main() {
        IntList list = new IntList();
        list.addLast(13);
        list.addFirst(67);
        list.addLast(2);
        list.addFirst(52);
        System.out.println(list);
        list.add(0,5);
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(0));
        list.set(3, 123);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        list.removeItem(67);
        System.out.println(list);
    }
}
