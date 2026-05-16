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
        id[0]=1;  nama[0]="Matematika Dasar";       kategori[0]="Sains";     jumlah[0]=15;
        id[1]=2;  nama[1]="Fisika Modern";           kategori[1]="Sains";     jumlah[1]=8;
        id[2]=3;  nama[2]="Kimia Organik";           kategori[2]="Sains";     jumlah[2]=12;
        id[3]=4;  nama[3]="Biologi Sel";             kategori[3]="Sains";     jumlah[3]=20;
        id[4]=5;  nama[4]="Statistika Terapan";      kategori[4]="Sains";     jumlah[4]=6;
        id[5]=6;  nama[5]="Kalkulus Lanjut";         kategori[5]="Sains";     jumlah[5]=9;
        id[6]=7;  nama[6]="Pemrograman Java";        kategori[6]="Teknologi"; jumlah[6]=25;
        id[7]=8;  nama[7]="Basis Data";              kategori[7]="Teknologi"; jumlah[7]=18;
        id[8]=9;  nama[8]="Jaringan Komputer";       kategori[8]="Teknologi"; jumlah[8]=11;
        id[9]=10; nama[9]="Kecerdasan Buatan";       kategori[9]="Teknologi"; jumlah[9]=30;
        id[10]=11; nama[10]="Struktur Data";         kategori[10]="Teknologi"; jumlah[10]=14;
        id[11]=12; nama[11]="Keamanan Siber";        kategori[11]="Teknologi"; jumlah[11]=7;
        id[12]=13; nama[12]="Algoritma Pemrograman"; kategori[12]="Teknologi"; jumlah[12]=22;
        id[13]=14; nama[13]="Sejarah Indonesia";     kategori[13]="Sejarah";  jumlah[13]=10;
        id[14]=15; nama[14]="Sejarah Dunia";         kategori[14]="Sejarah";  jumlah[14]=13;
        id[15]=16; nama[15]="Perang Dunia II";       kategori[15]="Sejarah";  jumlah[15]=8;
        id[16]=17; nama[16]="Revolusi Industri";     kategori[16]="Sejarah";  jumlah[16]=5;
        id[17]=18; nama[17]="Sejarah Islam";         kategori[17]="Sejarah";  jumlah[17]=16;
        id[18]=19; nama[18]="Dinasti Ming";          kategori[18]="Sejarah";  jumlah[18]=4;
        id[19]=20; nama[19]="Kolonialisme Eropa";    kategori[19]="Sejarah";  jumlah[19]=9;
        id[20]=21; nama[20]="Sejarah Romawi";        kategori[20]="Sejarah";  jumlah[20]=11;
        id[21]=22; nama[21]="Bahasa Indonesia";      kategori[21]="Bahasa";   jumlah[21]=17;
        id[22]=23; nama[22]="Bahasa Inggris";        kategori[22]="Bahasa";   jumlah[22]=23;
        id[23]=24; nama[23]="Bahasa Jepang";         kategori[23]="Bahasa";   jumlah[23]=14;
        id[24]=25; nama[24]="Linguistik Umum";       kategori[24]="Bahasa";   jumlah[24]=6;
        id[25]=26; nama[25]="Sastra Indonesia";      kategori[25]="Bahasa";   jumlah[25]=10;
        id[26]=27; nama[26]="Tata Bahasa Inggris";   kategori[26]="Bahasa";   jumlah[26]=19;
        id[27]=28; nama[27]="Bahasa Arab";           kategori[27]="Bahasa";   jumlah[27]=8;
        id[28]=29; nama[28]="Pengantar Linguistik";  kategori[28]="Bahasa";   jumlah[28]=12;
        id[29]=30; nama[29]="Semantik dan Pragmatik"; kategori[29]="Bahasa";  jumlah[29]=5;
        jumlahData = 30;
    
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