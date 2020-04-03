import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner sc = new Scanner(System.in);

        try {
            File file = new File("Laporan.txt");
            Scanner sc2 = new Scanner(file);

            while (sc2.hasNextLine()) {
                String data = sc2.nextLine();
                String splitter[] = data.split(":");
                ll.add(splitter[0]);

                if (ll.searchData(splitter[0]) != null) {
                    ll.searchData(splitter[0]).getData().addJudul(splitter[1]);
                }
            }
            sc2.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        ll.bubbleSort();
        // tampilan program
        while (true) {
            System.out.print(
                    "\n--------LinkedList Program--------\n\n1. Pilih Editor\n2. Tampilkan Data Editor\n3. Pilih Editor dan Tampilkan Judul Artikel\n4. Keluar\nMasukkan Pilihan : ");
            int pilihan = Integer.parseInt(sc.nextLine());
            if (pilihan == 1) {
                System.out.print("Masukkan Nama Editor : ");
                String editor = sc.nextLine();
                ll.displayEditorArtikel();
            } else if (pilihan == 2) {
                ll.display();
                System.out.println("");
            } else if (pilihan == 3) {
                System.out.print("Masukkan Nama Editor : ");
                String editor = sc.nextLine();
                ll.menubaru(editor);
            } else if (pilihan == 4) {
                System.exit(1);
            } else {
                System.out.println("Pilihan Tidak Ditemukan\n");
            }

        }
    }
}