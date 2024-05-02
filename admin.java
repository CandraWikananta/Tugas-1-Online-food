import java.util.*;

public class admin {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Restoran> restaurant = new ArrayList<>();

    public static String getString() {
        String text;
        while (true) {
            text = scanner.nextLine();
            if (text != null && text.length() != 0) {
                break;
            } else {
                System.out.print("Input invalid. Mohon ulangi.\n> ");
            }
        }
        return text;
    }

    public static void tambahResto(Restoran restaurants) {
        restaurant.add(restaurants);
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
        System.out.print(">");
        int pilihanMenu = scanner.nextInt();
        scanner.nextLine();

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
        for (int i = 0; i < restaurant.size(); i++) {
            Restoran restoran = restaurant.get(i);
            System.out.printf("%d. %s - %s\n", i + 1, restoran.getNamaResto(), restoran.getAlamat());
            id++;
        }

        int idResto = 0;
        System.out.println("masukkan id resto : ");
        idResto = scanner.nextInt();

        ArrayList<ArrayList<String>> makanan = new ArrayList<>();
        ArrayList<ArrayList<String>> minuman = new ArrayList<>();

        makanan = restaurant.get(idResto - 1).getMakanan();
        minuman = restaurant.get(idResto - 1).getMinuman();

        System.out.printf("%s, %s", restaurant.get(idResto - 1).getNamaResto(),
                restaurant.get(idResto - 1).getAlamat());

    }

    private static void tambahRestoran() {
        int pilihan = 0;
        int konfirm = 0;
        System.out.println("MASUKKAN NAMA RESTORAN : ");
        String namaResto = getString();

        System.out.println("MASUKKAN ALAMAT RESTORAN : ");
        String alamat = scanner.nextLine();
        Restoran restoran = new Restoran(namaResto, alamat);

        do {
            System.out.println("1. makanan");
            System.out.println("2. minuman");
            System.out.println("0. kembali");

            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 0) {
                tambahRestoran();
                return;
            }

            System.out.println("masukkan nama menu");
            String namaMenu = scanner.nextLine();

            System.out.println("masukkan harga menu");
            String hargaMenu = scanner.nextLine();

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

            System.out.println("apakah anda ingin menambah lagi? 1 YA 0 TIDAK");
            konfirm = scanner.nextInt();
            scanner.nextLine();

        } while (konfirm != 0);

        tambahResto(restoran);
        System.out.println("data berhasil ditambahkan");
        adminMenu();
    }

    private static void hapusRestoran() {

    }

}