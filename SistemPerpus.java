import java.util.Scanner;

public class SistemPerpus {
    static Scanner input = new Scanner(System.in);

    // Struktur data
    static int[] id = new int[100];
    static String[] nama = new String[100];
    static String[] kategori = new String[100];
    static int [] jumlah = new int[100];
    static int jumlahData = 0;

    public static void main(String[] args) {

        // Inisialisasi data awal buku
    
        int pilihan;
        do {
            System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Cari Nama (Linear)");
            System.out.println("6. Cari ID (Binary)");
            System.out.println("7. Cari Kategori");
            System.out.println("8. Sort ID");
            System.out.println("9. Sort Nama"); 
            System.out.println("10. Sort Jumlah");
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
                case 7: cariKategori(); break;
                case 8: sortID(); break;
                case 9: sortNama(); break;
                case 10: sortJumlahDescending(); break;
                case 0: 
                    System.out.println("Program Selesai");
                    break;
                default: 
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }

    // Method menambahkan data buku baru
    static void tambahData() {
        System.out.print("ID: ");
        id[jumlahData] = input.nextInt();
        input.nextLine();

        System.out.print("Nama Buku: ");
        nama[jumlahData] = input.nextLine();

        System.out.print("Kategori: ");
        kategori[jumlahData] = input.nextLine();

        System.out.print("Jumlah Buku: ");
        jumlah[jumlahData] = input.nextInt();
        
        jumlahData++;
    }

    // Method menampilkan seluruh data buku
    static void tampilData() {
        if (jumlahData == 0) {
        System.out.println("Data kosong");
        return;
    }
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(id[i] + " | " + nama[i] + " | " + kategori[i] + " | " + jumlah[i]);
        }
    }

    // Method mengubah data buku berdasarkan ID
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
            System.out.print("Jumlah baru: ");
            jumlah[index] = input.nextInt();
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Method menghapus data buku berdasarkan ID
    static void hapusData() {
        System.out.print("Masukkan ID yang ingin dihapus: ");
        int key = input.nextInt();
        int index = linearSearchID(key);

        if (index != -1) {
            for (int i = index; i < jumlahData - 1; i++) {
                id[i] = id[i + 1];
                nama[i] = nama[i + 1];
                kategori[i] = kategori[i + 1];
                jumlah[i] = jumlah[i + 1];
            }
            jumlahData--;
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Method Linear Search untuk mencari buku berdasarkan nama
    static void cariNama() {
        input.nextLine();

        System.out.print("Masukkan nama: ");
        String key = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (nama[i].equalsIgnoreCase(key)) {
                System.out.println("Ditemukan: " + id[i] + " | " + nama[i] + " | " + kategori[i] + " | " + jumlah[i]);
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }

    // Method Binary Search untuk mencari buku berdasarkan ID
    static void cariID() {
        bubbleSortID();
        System.out.print("Masukkan ID: ");
        int key = input.nextInt();
        int hasil = binarySearch(key);

        if (hasil != -1) {
            System.out.println("Ditemukan: " + id[hasil] + " | " + nama[hasil] + " | " + kategori[hasil] + " | " + jumlah[hasil]);
        } else {
            System.out.println("Tidak ditemukan");
        }
    }

    // Method Linear Search untuk mencari buku berdasarkan kategori
    static void cariKategori() {
        input.nextLine();

        System.out.print("Masukkan kategori: ");
        String key = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {

            if (kategori[i].equalsIgnoreCase(key)) {

                System.out.println(
                        id[i] + " | " +
                        nama[i] + " | " +
                        kategori[i] + " | " +
                        jumlah[i]
                );

                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Kategori tidak ditemukan");
        }
    }

    // Method Bubble Sort untuk mengurutkan ID secara ascending
    static void sortID() {
        bubbleSortID();

        System.out.println("=== Data Setelah Diurutkan ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(
                id[i] + " | " +
                nama[i] + " | " +
                kategori[i] + " | " +
                jumlah[i]
            ); 
        }
    }

    // Method Selection Sort untuk mengurutkan nama buku A-Z
    static void sortNama() {
        selectionSortNama();

        System.out.println("=== Data Setelah Diurutkan (A-Z) ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(
                id[i] + " | " +
                nama[i] + " | " +
                kategori[i] + " | " +
                jumlah[i]
            ); 
        }
    }

    // Kumpulan method sorting

    // Bubble Sort ascending berdasarkan ID buku
    static void bubbleSortID() {
        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - 1 - i; j++) {
                if (id[j] > id[j + 1]) {
                    // tukar semua atribut
                    swap(j, j + 1);
                }
            }
        }
    }

    // Selection Sort ascending berdasarkan nama buku
    static void selectionSortNama() {
        for (int i = 0; i < jumlahData - 1; i++) {
        int minIndex = i;
            for (int j = i + 1; j < jumlahData; j++) {
                if (nama[j].compareToIgnoreCase(nama[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
    }

    // Kumpulan method searching

    // Binary Search untuk mencari ID buku
    static int binarySearch(int key) {
        int low = 0, high = jumlahData - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (id[mid] == key) return mid;
            else if (id[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Linear Search untuk mencari posisi ID buku
    static int linearSearchID(int key) {
        for (int i = 0; i < jumlahData; i++) {
            if (id[i] == key) return i;
        }
        return -1;
    }

    // Method untuk menukar seluruh atribut data buku
    static void swap(int a, int b) {
        int tempId = id[a];
        id[a] = id[b];
        id[b] = tempId;

        String tempNama = nama[a];
        nama[a] = nama[b];
        nama[b] = tempNama;

        String tempKategori = kategori[a];
        kategori[a] = kategori[b];
        kategori[b] = tempKategori;

        int tempJumlah = jumlah[a];
        jumlah[a] = jumlah[b];
        jumlah[b] = tempJumlah;
    }

    // Bubble Sort descending berdasarkan jumlah buku
    static void sortJumlahDescending() {

    for (int i = 0; i < jumlahData - 1; i++) {
        for (int j = 0; j < jumlahData - 1 - i; j++) {
            if (jumlah[j] < jumlah[j + 1]) {
                swap(j, j + 1);
            }
        }
    }

    System.out.println("=== Data Setelah Diurutkan (Descending) ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println(
                id[i] + " | " +
                nama[i] + " | " +
                kategori[i] + " | " +
                jumlah[i]
            );
        }
    }
}