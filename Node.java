
public class Node {
    private Data data;
    private Node next;

    public Data getData() {
        return this.data;
    }

    public Node getNext() {
        if (this.hasNext()) {
            return this.next;
        }
        return null;
    }

    public Node(Data data, Node next) {
        this.setNext(next);
        this.setData(data);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}