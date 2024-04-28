import java.util.*;

public class Admin {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> restaurant = new ArrayList<>();

    public static void main(String[] args) {
        adminMenu();
    }

    private static void adminMenu() {
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
        } 
    
        
    }

    private static void tambahRestoran() {
        int pilihan = 0;
        int konfirm = 0;
        System.out.println("MASUKKAN NAMA RESTORAN : ");
        String namaResto = scanner.next();
        scanner.nextLine();
        System.out.println("MASUKKAN ALAMAT RESTORAN : ");
        String alamat = scanner.nextLine();
        Restoran restoran = new Restoran(namaResto, alamat);

        do {
            System.out.println("1. makanan");
            System.out.println("2. minuman");
            System.out.println("0. kembali");

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

            System.out.println("apakah anda ingin menambah lagi?");

        } while (konfirm != 0);
    }

    private static void hapusRestoran() {

    }

}
