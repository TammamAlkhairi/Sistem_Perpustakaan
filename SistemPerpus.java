import java.util.Scanner;

public class SistemPerpus {
    static Scanner input = new Scanner(System.in);

    // Struktur data
    static int[] id = new int[100];
    static String[] nama = new String[100];
    static String[] kategori = new String[100];
    static int jumlahData = 0;

    public static void main(String[] args) {

        // Tambah data awal
        tambahDataAwal();

        int pilihan;
        do {
            System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Cari Nama (Linear)");
            System.out.println("6. Cari ID (Binary)");
            System.out.println("7. Sort ID (Bubble)");
            System.out.println("8. Sort Nama (Selection)");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1: tambahData(); break;
                case 2: tampilData(); break;
                case 3: editData(); break;
                case 4: hapusData(); break;
                case 5: cariNama(); break;
                case 6: cariID(); break;
                case 7: bubbleSortID(); break;
                case 8: selectionSortNama(); break;
            }
        } while (pilihan != 0);
    }

    // Tambah Data
    static void tambahData() {
        System.out.print("ID: ");
        id[jumlahData] = input.nextInt();
        input.nextLine();
        System.out.print("Nama Buku: ");
        nama[jumlahData] = input.nextLine();
        System.out.print("Kategori: ");
        kategori[jumlahData] = input.nextLine();
        jumlahData++;
    }

    //Menampilkan Data
    static void tampilData() {
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(id[i] + " | " + nama[i] + " | " + kategori[i]);
        }
    }

    // Edit Data
    static void editData() {
        System.out.print("Masukkan ID yang ingin diedit: ");
        int key = input.nextInt();
        int index = linearSearchID(key);

        if (index != -1) {
            input.nextLine();
            System.out.print("Nama baru: ");
            nama[index] = input.nextLine();
            System.out.print("Kategori baru: ");
            kategori[index] = input.nextLine();
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Menghapus data
    static void hapusData() {
        System.out.print("Masukkan ID yang ingin dihapus: ");
        int key = input.nextInt();
        int index = linearSearchID(key);

        if (index != -1) {
            for (int i = index; i < jumlahData - 1; i++) {
                id[i] = id[i + 1];
                nama[i] = nama[i + 1];
                kategori[i] = kategori[i + 1];
            }
            jumlahData--;
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Cari berdasarkan ID
    static int linearSearchID(int key) {
        for (int i = 0; i < jumlahData; i++) {
            if (id[i] == key) return i;
        }
        return -1;
    }

    // Cari berdasarkan Nama
    static void cariNama() {
        input.nextLine();

        System.out.print("Masukkan nama: ");
        String key = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (nama[i].equalsIgnoreCase(key)) {
                System.out.println("Ditemukan: " + id[i] + " | " + nama[i]);
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }
}