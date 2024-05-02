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
        ArrayList<ItemPesanan> pesananItems = new ArrayList<>();
        ArrayList<ItemPesanan> makananPesanan = new ArrayList<>();
        ArrayList<ItemPesanan> minumanPesanan = new ArrayList<>();

        boolean pesanLagi = true;
        int totalHarga = 0;
        int jumlahPesan = 0;

        ArrayList<String> food = null;
        ArrayList<String> drink = null;

        System.out.println("[]===================================[]");
        System.out.println("||           Daftar Restoran         ||");
        System.out.println("[]===================================[]\n");
        for (int i = 0; i < restaurants.size(); i++) {
            Restoran restoran = restaurants.get(i);
            System.out.printf("%d. %s-%s\n", i + 1, restoran.getNamaResto(), restoran.getAlamat());
            System.out.println("---------------------------------------");
        }

        // Memilih restoran
        System.out.print("Pilih nomor restoran: ");
        int restoranIndex = userInput.getIntegerbiasa();

        if (restoranIndex < 1 || restoranIndex > restaurants.size()) {
            System.out.println("Nomor restoran tidak valid.");
            return;
        }

        Restoran restoranPilihan = restaurants.get(restoranIndex - 1);

        while (pesanLagi) {
            App.clearScreen();
            System.out.println("[]==============================[]");
            System.out.println("       Menu " + restoranPilihan.getNamaResto());
            System.out.println("[]==============================[]\n");

            System.out.println("Menu Makanan:");
            ArrayList<ArrayList<String>> makanan = restoranPilihan.getMakanan();
            for (int i = 0; i < makanan.size(); i++) {
                food = makanan.get(i);
                System.out.printf("[%d] %s - Rp. %s\n", i + 1, food.get(0), food.get(1));
            }
            System.out.println("----------------------------------");
            System.out.println("Menu Minuman:");
            ArrayList<ArrayList<String>> minuman = restoranPilihan.getMinuman();
            for (int i = 0; i < minuman.size(); i++) {
                drink = minuman.get(i);
                System.out.printf("[%d] %s - Rp. %s\n", i + 1, drink.get(0), drink.get(1));
            }

            System.out.println("\nApakah ingin memesan makanan atau minuman? (makanan/minuman): ");
            System.out.print("> ");
            String jenisPesan = userInput.getString();

            if (!jenisPesan.equalsIgnoreCase("makanan") && !jenisPesan.equalsIgnoreCase("minuman")) {
                System.out.println("Jenis pesanan tidak valid.");
                userInput.hold();
                orderFood(restaurants);
            }

            System.out.print("Pilih nomor menu " + jenisPesan + " yang ingin dipesan: ");
            int menuIndex = userInput.getIntegerbiasa();

            ArrayList<ArrayList<String>> pesanan;
            if (jenisPesan.equalsIgnoreCase("makanan")) {
                pesanan = makanan;
            } else {
                pesanan = minuman;
            }

            if (menuIndex < 1 || menuIndex > pesanan.size()) {
                System.out.println("Nomor menu tidak valid.");
                return;
            }

            // Menentukan indeks menu di dalam ArrayList
            int indexMenu = menuIndex - 1;

            System.out.print("Masukkan jumlah " + jenisPesan + " yang ingin dipesan: ");
            jumlahPesan = userInput.getIntegerbiasa();

            if (jenisPesan.equalsIgnoreCase("makanan")) {
                makananPesanan.add(new ItemPesanan(pesanan.get(indexMenu).get(0), Integer.parseInt(pesanan.get(indexMenu).get(1)), jumlahPesan));
            } else {
                minumanPesanan.add(new ItemPesanan(pesanan.get(indexMenu).get(0), Integer.parseInt(pesanan.get(indexMenu).get(1)), jumlahPesan));
            }

            App.clearScreen();
            System.out.println("[]====================================[]");
            System.out.println("||            Pesanan Anda            ||");
            System.out.println("[]====================================[]\n");

            System.out.println("Restoran: " + restoranPilihan.getNamaResto());
            System.out.println("------------------------------------");
            System.out.println("Menu: " + jenisPesan + " - " + pesanan.get(indexMenu).get(0));
            System.out.println("Harga: Rp. " + pesanan.get(indexMenu).get(1));
            System.out.println("Jumlah: " + jumlahPesan);
            System.out.println("Sub Total: Rp." + jumlahPesan * Integer.valueOf(pesanan.get(indexMenu).get(1)));

            totalHarga += (jumlahPesan * Integer.parseInt(pesanan.get(indexMenu).get(1)));

            System.out.print("\nApakah ingin memesan lagi? (ya/tidak): ");
            String input = userInput.getString();

            if (!input.equalsIgnoreCase("ya")) {
                pesanLagi = false;
            }
        }

        System.out.print("Masukkan jarak rumah anda (KM): ");
        int jarakRumah = userInput.getIntegerbiasa();
        int hargaOngkir = jarakRumah * 1850;

        System.out.println("Total Harga Makanan: Rp. " + totalHarga);
        System.out.println("Harga Ongkir: Rp. " + hargaOngkir);
        
        int totalHargaKeseluruhan = totalHarga + hargaOngkir;
        System.out.println("Total Harga: Rp. " + totalHargaKeseluruhan);

        Pesanan pesananBaru = new Pesanan(restoranIndex, makananPesanan, minumanPesanan, jarakRumah, totalHarga, restaurants);        
        riwayatPesanan.add(pesananBaru);


        userInput.hold();
        menuCustomer();
    }

    public static void lihatRestoran(){
        ArrayList<Restoran> restaurants = admin.getRestaurants();
        System.out.println("Daftar Restoran:");
        int id = 1;
        for (Restoran restoran : restaurants) {
            System.out.printf("%d. %s-%s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }

        System.out.print("Pilih nomor restoran: ");
        int restoranIndex = userInput.getInteger(1, restaurants.size());

        Restoran restoranPilihan = restaurants.get(restoranIndex - 1);

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
                int idRestoran = pesanan.getIdRestoran();
                ArrayList<Restoran> daftarRestoran = pesanan.getDaftarRestoran();
    
                if (idRestoran >= 1 && idRestoran <= daftarRestoran.size()) {
                    Restoran restoran = daftarRestoran.get(idRestoran - 1);
                    System.out.println("ID Restoran: " + idRestoran);
                    System.out.println("Nama Restoran: " + restoran.getNamaResto());
                } else {
                    System.out.println("ID Restoran tidak valid");
                }
    
                System.out.println("Makanan:");
                for (ItemPesanan item : pesanan.getMakananPesanan()) {
                    System.out.println("Nama Item: " + item.getNama()); 
                    System.out.println("Jumlah Pesanan: " + item.getJumlah()); 
                    System.out.println("Harga: " + item.getHarga()); 
                    System.out.println(); 
                }
    
                System.out.println("Minuman:");
                for (ItemPesanan item : pesanan.getMinumanPesanan()) {
                    System.out.println("Nama Item: " + item.getNama()); 
                    System.out.println("Jumlah Pesanan: " + item.getJumlah()); 
                    System.out.println("Harga: " + item.getHarga()); 
                    System.out.println(); 
                }
    
                System.out.println("Jarak: " + pesanan.getJarak() + " KM");
                System.out.println("Total Harga Makanan: Rp. " + pesanan.getTotalHarga());
    
                int hargaOngkir = pesanan.getJarak() * 1850;
                System.out.println("Harga Ongkir: Rp. " + hargaOngkir);
    
                int totalHargaKeseluruhan = pesanan.getTotalHarga() + hargaOngkir;
                System.out.println("Total Harga Keseluruhan: Rp. " + totalHargaKeseluruhan);
                System.out.println();
            }
        }
    
        userInput.hold(); 
        menuCustomer(); 
    }
    

}
