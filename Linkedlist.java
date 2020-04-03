
public class Linkedlist {

    private Node head;
    private int size;

    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int Size() {
        return this.size;
    }

    public void add(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound == null) {
            this.setHead(new Node(new Data(editor), this.getHead()));
        } else {
            isFound.getData().addFreq();
        }

    }

    public void display() {
        Node current = this.getHead();

        while (current != null) {
            System.out.println(current.getData().getName());
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }

    public Node searchData(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().equals(editor))
                return current;
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }

        return null;
    }

    public String fetchData(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound != null) {
            return isFound.getData().getName() + " ditemukan dengan total artikel yang diedit adalah "
                    + isFound.getData().getFreq() + ".";
        } else {
            return "Nama dari " + editor + " tidak ditemukan.";
        }
    }

    public void bubbleSort() {
        if (size > 1) {
            boolean Diubah;
            do {
                Node current = head;
                Node previous = null;
                Node next = head.getNext();
                Diubah = false;

                while (next != null) {
                    if (current.getData().getName().toLowerCase()
                            .compareTo(next.getData().getName().toLowerCase()) > 0) {
                        Diubah = true;

                        if (previous != null) {
                            Node sig = next.getNext();

                            previous.setNext(next);
                            next.setNext(current);
                            current.setNext(sig);
                        } else {
                            Node sig = next.getNext();

                            head = next;
                            next.setNext(current);
                            current.setNext(sig);
                        }

                        previous = next;
                        next = current.getNext();
                    } else {
                        previous = current;
                        current = next;
                        next = next.getNext();
                    }
                }
            } while (Diubah);
        }
    }

    public void menubaru(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound != null) {
            System.out.println(isFound.getData().getName() + " mengedit " + isFound.getData().getFreq() + " artikel.");
            isFound.getData().getJudul();

        } else {
            System.out.println("Data " + editor + " tidak ditemukan.");
        }
    }

    public void sort() {
        Node current = this.getHead();
        Data tempData;
        while (current.getNext() != null) {
            while (current.getData().getName().compareTo(current.getNext().getData().getName()) > 0) {
                tempData = current.getNext().getData();
                current.getNext().setData(current.getData());
                current.setData(tempData);
                current = this.getHead();
            }
            current = current.getNext();
        }
    }
    public void displayEditorArtikel() {
        sort();
        Node current = this.getHead();

        while (current != null) {
            System.out.println(current.getData().getName() + " - Menulis " + current.getData().getFreq() + " Artikel");
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }
}
