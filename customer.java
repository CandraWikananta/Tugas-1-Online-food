import java.util.ArrayList;
import java.util.Scanner;

public class customer {

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
                systemCLS.clearScreen();
                System.out.println("Daftar nama Restaurant");
                
                break;

            case 2:
                systemCLS.clearScreen();
                System.out.println("Pesan Makanan");
                ArrayList<Restoran> restaurants = admin.getRestaurants();
                orderFood(restaurants);
                break;
            
            case 3:
                systemCLS.clearScreen();
                System.out.println("Riwayat Pemesanan");
                break;
            
            case 4:
                main.main(null);
                break;
        
            default:
            System.out.println("Pilihan anda salah!");
                break;
        }

    }

    public static void orderFood(ArrayList<Restoran> restaurants){
        Scanner scanner = new Scanner(System.in);
        // Menampilkan daftar restoran
        System.out.println("Daftar Restoran:");
        int id = 1;
        for (Restoran restoran : restaurants) {
            System.out.printf("%d. %s-%s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
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

        // Memilih menu
        System.out.print("Pilih nomor menu yang ingin dipesan: ");
        int menuIndex = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        // Validasi nomor menu
        if (menuIndex < 1 || menuIndex > makanan.size() + minuman.size()) {
            System.out.println("Nomor menu tidak valid.");
            return;
        }

        // Menentukan jenis menu dan indeksnya di dalam ArrayList
        String jenisMenu;
        int indexMenu;
        if (menuIndex <= makanan.size()) {
            jenisMenu = "Makanan";
            indexMenu = menuIndex - 1;
        } else {
            jenisMenu = "Minuman";
            indexMenu = menuIndex - makanan.size() - 1;
        }

        // Memilih jumlah pesanan
        System.out.print("Masukkan jumlah yang ingin dipesan: ");
        int jumlahPesan = scanner.nextInt();
        scanner.nextLine(); // Membuang newline character

        // Menampilkan rincian pesanan
        System.out.println("Pesanan Anda:");
        System.out.println("Restoran: " + restoranPilihan.getNamaResto());
        System.out.println("Menu: " + jenisMenu + " - " + (jenisMenu.equals("Makanan") ? makanan.get(indexMenu).get(0) : minuman.get(indexMenu).get(0)));
        System.out.println("Harga: Rp. " + (jenisMenu.equals("Makanan") ? makanan.get(indexMenu).get(1) : minuman.get(indexMenu).get(1)));
        System.out.println("Jumlah: " + jumlahPesan);
        scanner.close();
    }
}
