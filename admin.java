import java.util.*;

public class admin {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Restoran> restaurant = new ArrayList<>();

    public static void tambahResto(Restoran restaurants) {
        restaurant.add(restaurants);
    }

    public static ArrayList<Restoran> getRestaurants() {
        return restaurant;
    }

    public static void hapusResto(int idResto) {
        restaurant.remove(idResto);
    }

    public static void adminMenu() {
        System.out.println(
                "[]================================[]\n" +
                        "|| Selamat datang di menu Admin!  ||\n" +
                        "[]================================[]\n" +
                        "||1. Lihat restoran               ||\n" +
                        "||2. Tambah restoran              ||\n" +
                        "||3. Hapus restoran               ||\n" +
                        "||4. Kembali ke login             ||\n" +
                        "[]================================[]\n");
        System.out.println("Masukkan pilihan : ");
        int pilihanMenu = userInput.getInteger(1, 4);
        systemCLS.clearScreen();

        switch (pilihanMenu) {
            case 1:
                lihatRestoran();
                break;

            case 2:
                tambahRestoran();
                break;

            case 3:
                hapusRestoran();
                break;

            case 4:
                System.out.println("[]===========================================[]");
                System.out.println("[] Terimakasih Telah Menggunakan Program Kami[]");
                System.out.println("[]===========================================[]");
                userInput.hold();
                Login.logIn();
                break;
        }
    }

    private static void lihatRestoran() {
        if (restaurant.size() == 0) {
            System.out.println("Tidak ada restoran, tambahkan restroan terlebih dahulu :)");
            adminMenu();
            return;
        }

        int id = 1;

        System.out.println("[]===========================================[]");
        System.out.println("[]                LIST RESTORAN              []");
        System.out.println("[]===========================================[]");
        for (Restoran restoran : restaurant) {
            System.out.printf("%d. %s - %s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }
        System.out.println("");
        System.out.println("Masukkan ID restoran : ");
        int idResto = userInput.getIntegerbiasa();

        if (idResto < 1 || idResto > restaurant.size()) {
            System.out.println("ID restoran tidak valid.");
            return;
        }
        systemCLS.clearScreen();
        Restoran restoranPilihan = restaurant.get(idResto - 1);

        System.out.printf("Restoran : %s - %s\n", restoranPilihan.getNamaResto(), restoranPilihan.getAlamat());
        System.out.println("Menu Makanan:");

        ArrayList<ArrayList<String>> makanan = restoranPilihan.getMakanan();
        if (makanan.size() == 0) {
            System.out.println("Tidak ada makanan.");
        } else {
            for (int i = 0; i < makanan.size(); i++) {
                ArrayList<String> food = makanan.get(i);
                System.out.printf("%d. %s - Rp. %s\n", i + 1, food.get(0), food.get(1));
            }
        }
        System.out.println("");
        System.out.println("Menu Minuman:");

        ArrayList<ArrayList<String>> minuman = restoranPilihan.getMinuman();
        if (minuman.size() == 0) {
            System.out.println("Tidak ada minuman.");
        } else {
            for (int i = 0; i < minuman.size(); i++) {
                ArrayList<String> drink = minuman.get(i);
                System.out.printf("%d. %s - Rp. %s\n", i + 1, drink.get(0), drink.get(1));
            }
        }
        userInput.hold();
        systemCLS.clearScreen();
        adminMenu();
    }

    private static void tambahRestoran() {
        int pilihan = 0;
        int konfirm = 0;
        System.out.println("Masukkan nama restoran : ");
        String namaResto = userInput.getString();

        System.out.println("Masukkan alamat restoran : ");
        String alamat = userInput.getString();

        Restoran restoran = new Restoran(namaResto, alamat);
        systemCLS.clearScreen();

        do {
            systemCLS.clearScreen();
            System.out.println("[]===========================================[]");
            System.out.println("||    Pilih menu yang ingin ditambahkan!     ||");
            System.out.println("||                1. Makanan                 ||");
            System.out.println("||                2. Minuman                 ||");
            System.out.println("||          0. Kembali ke menu utama         ||");
            System.out.println("[]===========================================[]");
            pilihan = userInput.getInteger(0, 2);

            if (pilihan == 0) {
                systemCLS.clearScreen();
                adminMenu();
                return;
            }

            System.out.println("Masukkan nama menu");
            String namaMenu = userInput.getString();

            System.out.println("Masukkan harga menu");
            String hargaMenu = Double.toString(userInput.getDouble());

            switch (pilihan) {
                case 1:
                    restoran.addMakanan(namaMenu, hargaMenu);
                    break;

                case 2:
                    restoran.addMinuman(namaMenu, hargaMenu);
                    break;

                default:
                    break;
            }

            System.out.println("Apakah anda ingin menambah menu lagi?");
            System.out.println("|1| untuk menambahkan menu lagi - |0| untuk berhenti menambahkan menu");
            konfirm = userInput.getInteger(0, 1);

        } while (konfirm != 0);
        tambahResto(restoran);
        systemCLS.clearScreen();
        System.out.println("Restoran berhasil ditambahkan!!");
        userInput.hold();
        systemCLS.clearScreen();
        adminMenu();
    }

    private static void hapusRestoran() {
        if (restaurant.size() == 0) {
            System.out.println("Tidak ada restoran yang bisa dihapus, tambahkan restoran terlebih dahulu :)");
            userInput.hold();
            systemCLS.clearScreen();
            adminMenu();
            return;
        }

        System.out.println("[]===========================================[]");
        System.out.println("[]                LIST RESTORAN              []");
        System.out.println("[]===========================================[]");

        int id = 1;
        for (Restoran restoran : restaurant) {
            System.out.printf("%d. %s-%s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }
        System.out.println("");
        System.out.println("Pilih ID Restoran yang ingin anda hapus (cont : 1)");
        int hapus = userInput.getIntegerbiasa();
        systemCLS.clearScreen();
        System.out.printf("Restoran : \t\t%s - %s",
                getRestaurants().get(hapus - 1).getNamaResto(),
                getRestaurants().get(hapus - 1).getAlamat());
        System.out.println("");
        System.out.println("!!!        APAKAH ANDA YAKIN MENGHAPUS RESTORAN INI?        !!!");
        System.out.println("!!! SEMUA DATA AKAN HILANG SAAT ANDA MENGHAPUS RESTORAN INI !!!");
        System.out.println("");
        System.out.println("|1| KONFIRMASI -- |0| KEMBALI KE MENU");
        int konfirm = userInput.getInteger(0, 1);

        if (konfirm == 1) {
            hapusResto(hapus - 1);
            systemCLS.clearScreen();
            System.out.println("Restoran sudah dihapus!");
            userInput.hold();
            systemCLS.clearScreen();
            adminMenu();
        } else {
            systemCLS.clearScreen();
            adminMenu();
        }

    }

}