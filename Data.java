public class Data {
    private String name;
    private int frek;
    private Linkedlist title = new Linkedlist();

    public Data(String name) {
        this.name = name;
        this.frek = 1;
    }

    public void addFreq() {
        this.frek++;
    }

    public void addJudul(String artikel) {
        title.add(artikel);
    }
    public String getName() {
        return this.name;
    }

    public int getFreq() {
        return this.frek;
    }
    public void getJudul() {
        Node current = title.getHead();
        int i = 1;
        while (current != null) {
            System.out.println(i + ". " + current.getData().getName());
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
            i++;
        }
    }
}