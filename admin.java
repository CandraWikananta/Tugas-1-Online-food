import java.util.*;

public class admin {
    public static String usernameAdmin = "admin";
    public static String passwordAdmin = "admin";
    
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
        System.out.print("> ");
        int pilihanMenu = userInput.getInteger(1, 4);
        App.clearScreen();

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
                App.logIn();
                break;
        }
    }

    private static void lihatRestoran() {
        if (restaurant.size() == 0) {
            System.out.println("Tidak ada restoran.");
            adminMenu();
            return; // Menghentikan eksekusi metode setelah menampilkan pesan
        }

        int id = 1;
        for (Restoran restoran : restaurant) {
            System.out.printf("%d. %s-%s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }

        System.out.println("Masukkan ID restoran : ");
        int idResto = scanner.nextInt();

        if (idResto < 1 || idResto > restaurant.size()) {
            System.out.println("ID restoran tidak valid.");
            return;
        }

        Restoran restoranPilihan = restaurant.get(idResto - 1);

        System.out.printf("%s - %s\n", restoranPilihan.getNamaResto(), restoranPilihan.getAlamat());
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
        App.clearScreen();

        do {
            App.clearScreen();
            System.out.println("[]===========================================[]");
            System.out.println("||    Pilih menu yang ingin ditambahkan!     ||");
            System.out.println("||                1. Makanan                 ||");
            System.out.println("||                2. Minuman                 ||");
            System.out.println("||          0. Kembali ke menu utama         ||");
            System.out.println("[]===========================================[]");

            System.out.print("> ");

            pilihan = userInput.getInteger(0, 2);

            if (pilihan == 0) {
                App.clearScreen();
                adminMenu();
                return;
            }

            System.out.println("Masukkan nama menu");
            System.out.print("> ");

            String namaMenu = userInput.getString();

            System.out.println("Masukkan harga menu");
            System.out.print("> ");

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

            System.out.println("Apakah anda ingin menambah menu lagi? 1 YA 0 TIDAK");
            System.out.print("> ");
            konfirm = userInput.getInteger(0, 1);

        } while (konfirm != 0);
        tambahResto(restoran);
        App.clearScreen();
        System.out.println("Restoran berhasil ditambahkan!!");
        userInput.hold();
        adminMenu();
    }

    private static void hapusRestoran() {
        if (restaurant.size() == 0) {
            System.out.println("Tidak ada restoran.");
            adminMenu();
            return; // Menghentikan eksekusi metode setelah menampilkan pesan
        }

        int id = 1;
        for (Restoran restoran : restaurant) {
            System.out.printf("%d. %s-%s\n", id, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }

        System.out.println("pilih yg mau di hapus");
        int hapus = userInput.getInteger(1, 2);

        System.out.printf("hapus : %s - %s",
                getRestaurants().get(hapus - 1).getNamaResto(),
                getRestaurants().get(hapus - 1).getAlamat());
        System.out.println("1 conf, 0 balik");
        int konfirm = userInput.getInteger(0, 1);
        if (konfirm == 1) {
            hapusResto(hapus - 1);
            System.out.println("sudha terhapus");
            adminMenu();
        } else {
            adminMenu();
        }

    }

}