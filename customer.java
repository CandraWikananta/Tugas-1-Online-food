import java.util.ArrayList;
import java.util.Scanner;

public class customer {
    public static String usernameCustomer = "customer";
    public static String passwordCustomer = "customer";

    private static ArrayList<Pesanan> riwayatPesanan = new ArrayList<>();

    public static void menuCustomer(){
        System.out.println("[]===================================[]");
        System.out.println("|| Selamat datang di menu Customer!  ||");
        System.out.println("[]===================================[]");
        System.out.println("|| Silahkan pilih menu               ||");
        System.out.println("|| [1] Lihat Restaurant              ||");
        System.out.println("|| [2] Pesan Makanan                 ||");
        System.out.println("|| [3] Lihat Riwayat Pemesanan       ||");
        System.out.println("|| [4] Log out                       ||");
        System.out.println("[]===================================[]");
        System.out.println("Masukkan Pilihan");
        System.out.print("> ");
        int choice = userInput.getInteger(1, 4);

        switch (choice) {
            case 1:
                App.clearScreen();
                lihatRestoran();
                break;

            case 2:
                App.clearScreen();
                ArrayList<Restoran> restaurants = admin.getRestaurants();
                orderFood(restaurants);
                break;
            
            case 3:
                App.clearScreen();
                riwayatPemesanan();
                break;
            
            case 4:
                App.logIn();
                break;
        
            default:
            System.out.println("Pilihan anda salah!");
                break;
        }

    }

    public static void orderFood(ArrayList<Restoran> restaurants) {
        ArrayList<ItemPesanan> makananPesanan = new ArrayList<>();
        ArrayList<ItemPesanan> minumanPesanan = new ArrayList<>();
        ArrayList<Restoran> daftarRestoran = admin.getRestaurants();

        Scanner scanner = new Scanner(System.in);
        boolean pesanLagi = true;
        int totalHarga = 0;
        int jumlahPesan = 0;

        ArrayList<String> food = null;
        ArrayList<String> drink = null;

        // Menampilkan daftar restoran
        System.out.println("Daftar Restoran:");
        for (int i = 0; i < restaurants.size(); i++) {
            Restoran restoran = restaurants.get(i);
            System.out.printf("%d. %s-%s\n", i + 1, restoran.getNamaResto(), restoran.getAlamat());
        }

        // Memilih restoran
        System.out.print("Pilih nomor restoran: ");
        int restoranIndex = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        if (restoranIndex < 1 || restoranIndex > restaurants.size()) {
            System.out.println("Nomor restoran tidak valid.");
            return;
        }

        Restoran restoranPilihan = restaurants.get(restoranIndex - 1);

        while (pesanLagi) {
            // Menampilkan menu restoran yang dipilih
            System.out.println("Menu " + restoranPilihan.getNamaResto() + ":");
            System.out.println("Menu Makanan:");
            ArrayList<ArrayList<String>> makanan = restoranPilihan.getMakanan();
            for (int i = 0; i < makanan.size(); i++) {
                food = makanan.get(i);
                System.out.printf("%d. %s - Rp. %s\n", i + 1, food.get(0), food.get(1));
            }

            // Memilih menu minuman
            System.out.println("Menu Minuman:");
            ArrayList<ArrayList<String>> minuman = restoranPilihan.getMinuman();
            for (int i = 0; i < minuman.size(); i++) {
                drink = minuman.get(i);
                System.out.printf("%d. %s - Rp. %s\n", i + 1, drink.get(0), drink.get(1));
            }

            // Memilih makanan atau minuman
            System.out.println("Apakah ingin memesan makanan atau minuman? (makanan/minuman): ");
            String jenisPesan = scanner.nextLine();

            if (!jenisPesan.equalsIgnoreCase("makanan") && !jenisPesan.equalsIgnoreCase("minuman")) {
                System.out.println("Jenis pesanan tidak valid.");
                return;
            }

            // Memilih menu makanan atau minuman
            System.out.print("Pilih nomor menu " + jenisPesan + " yang ingin dipesan: ");
            int menuIndex = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character

            ArrayList<ArrayList<String>> pesanan;
            if (jenisPesan.equalsIgnoreCase("makanan")) {
                pesanan = makanan;
                makananPesanan.add(new ItemPesanan(food.get(0), Integer.parseInt(food.get(1)), jumlahPesan));
            } else {
                pesanan = minuman;
                minumanPesanan.add(new ItemPesanan(drink.get(0), Integer.parseInt(drink.get(1)), jumlahPesan));
            }

            if (menuIndex < 1 || menuIndex > pesanan.size()) {
                System.out.println("Nomor menu tidak valid.");
                return;
            }

            // Menentukan indeks menu di dalam ArrayList
            int indexMenu = menuIndex - 1;

            // Memilih jumlah pesanan
            System.out.print("Masukkan jumlah " + jenisPesan + " yang ingin dipesan: ");
            jumlahPesan = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character

            // Menampilkan rincian pesanan
            System.out.println("Pesanan Anda:");
            System.out.println("Restoran: " + restoranPilihan.getNamaResto());
            System.out.println("Menu: " + jenisPesan + " - " + pesanan.get(indexMenu).get(0));
            System.out.println("Harga: Rp. " + pesanan.get(indexMenu).get(1));
            System.out.println("Jumlah: " + jumlahPesan);

            // Menghitung total harga pesanan
            totalHarga += (jumlahPesan * Integer.parseInt(pesanan.get(indexMenu).get(1)));

            // Meminta input untuk pesan lagi
            System.out.print("Apakah ingin memesan lagi? (ya/tidak): ");
            String input = scanner.nextLine();

            if (!input.equalsIgnoreCase("ya")) {
                pesanLagi = false;
            }
        }

        // Meminta input jarak rumah dan menghitung harga ongkir
        System.out.print("Masukkan jarak rumah anda (KM): ");
        int jarakRumah = scanner.nextInt();
        int hargaOngkir = jarakRumah * 1850;
        scanner.nextLine();

        // Menampilkan total harga makanan dan ongkir
        System.out.println("Total Harga Makanan: Rp. " + totalHarga);
        System.out.println("Harga Ongkir: Rp. " + hargaOngkir);
        
        // Menampilkan total harga keseluruhan
        int totalHargaKeseluruhan = totalHarga + hargaOngkir;
        System.out.println("Total Harga: Rp. " + totalHargaKeseluruhan);

        Pesanan pesananBaru = new Pesanan(restoranIndex, makananPesanan, minumanPesanan, jarakRumah, totalHargaKeseluruhan, daftarRestoran);
        riwayatPesanan.add(pesananBaru);


        waitForInput(scanner);
        menuCustomer();
        scanner.close();
    }

    public static void lihatRestoran(){
        ArrayList<Restoran> restaurants = admin.getRestaurants();
        System.out.println("Daftar Restoran:");
        int id = 1;
        for (Restoran restoran : restaurants) {
            System.out.printf("%d. %s-%s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }

        // Memilih restoran
        System.out.print("Pilih nomor restoran: ");
        int restoranIndex = userInput.getInteger(1, restaurants.size());

        Restoran restoranPilihan = restaurants.get(restoranIndex - 1);

        // Menampilkan menu restoran yang dipilih
        System.out.println("Menu " + restoranPilihan.getNamaResto() + ":");
        System.out.println("Menu Makanan:");
        ArrayList<ArrayList<String>> makanan = restoranPilihan.getMakanan();
        for (int i = 0; i < makanan.size(); i++) {
            ArrayList<String> food = makanan.get(i);
            System.out.printf("%d. %s - Rp. %s\n", i + 1, food.get(0), food.get(1));
        }

        System.out.println("Menu Minuman:");
        ArrayList<ArrayList<String>> minuman = restoranPilihan.getMinuman();
        for (int i = 0; i < minuman.size(); i++) {
            ArrayList<String> drink = minuman.get(i);
            System.out.printf("%d. %s - Rp. %s\n", i + 1, drink.get(0), drink.get(1));
        }
        menuCustomer();
    }

    public static void riwayatPemesanan() {
        System.out.println("Riwayat Pemesanan:");
    
        if (riwayatPesanan.isEmpty()) {
            System.out.println("Belum ada riwayat pemesanan.");
        } else {
            for (int i = 0; i < riwayatPesanan.size(); i++) {
                Pesanan pesanan = riwayatPesanan.get(i);
                System.out.println("Pesanan ke-" + (i + 1));
                System.out.println("ID Restoran: " + pesanan.getIdRestoran());
                
                // Ambil objek Restoran terkait dari daftar restoran
                ArrayList<Restoran> daftarRestoran = admin.getRestaurants();
                Restoran restoran = daftarRestoran.get(pesanan.getIdRestoran() - 1); // -1 karena indeks dimulai dari 0
    
                // Tampilkan nama restoran
                System.out.println("Nama Restoran: " + restoran.getNamaResto());
    
                // Tampilkan detail makanan
                System.out.println("Makanan:");
                for (ItemPesanan item : pesanan.getMakananPesanan()) {
                    System.out.println("Nama Item: " + item.getNama()); // Tampilkan nama item
                    System.out.println("Jumlah Pesanan: " + item.getJumlah()); // Tampilkan jumlah pesanan
                    System.out.println("Harga: " + item.getHarga()); // Tampilkan harga
                    System.out.println(); // Pindah ke baris berikutnya
                }
                // Tampilkan detail minuman
                System.out.println("Minuman:");
                for (ItemPesanan item : pesanan.getMinumanPesanan()) {
                    System.out.println("Nama Item: " + item.getNama()); // Tampilkan nama item
                    System.out.println("Jumlah Pesanan: " + item.getJumlah()); // Tampilkan jumlah pesanan
                    System.out.println("Harga: " + item.getHarga()); // Tampilkan harga
                    System.out.println(); // Pindah ke baris berikutnya
                }
                System.out.println("Jarak: " + pesanan.getJarak() + " KM");
                System.out.println("Total Harga: Rp. " + pesanan.getTotalHarga());
                System.out.println();
            }
        }
    
        waitForInput(new Scanner(System.in)); // Tunggu input sebelum kembali ke menu
        menuCustomer(); // Kembali ke menu utama
    }
    
    
    
    public static void waitForInput(Scanner scan) {
        System.out.println("Tekan tombol ENTER untuk lanjut");
        scan.nextLine();
    }

}
