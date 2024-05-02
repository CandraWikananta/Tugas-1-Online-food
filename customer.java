public class customer {
    public static void menuCustomer(){
        System.out.println("[]===================================[]");
        System.out.println("|| Selamat datang di menu Customer!  ||");
        System.out.println("[]===================================[]");
        System.out.println("|| Silahkan pilih menu               ||");
        System.out.println("|| [1] Lihat Restaurant              ||");
        System.out.println("|| [2] Pesan Makanan                 ||");
        System.out.println("|| [3] Lihat Riwayat Pemesanan       ||");
        System.out.println("|| [0] Log out                       ||");
        System.out.println("[]===================================[]");
        System.out.println("Masukkan Pilihan");
        System.out.print("> ");
        int choice = userInput.getInteger(0, 3);

        switch (choice) {
            case 1:
                systemCLS.clearScreen();
                System.out.println("Daftar nama Restaurant");
                break;

            case 2:
                systemCLS.clearScreen();
                System.out.println("Pesan Makanan");
                break;
            
            case 3:
                systemCLS.clearScreen();
                System.out.println("Riwayat Pemesanan");
                break;
            
            case 0:
                main.main(null);
                break;
        
            default:
            System.out.println("Pilighan anda salah!");
                break;
        }

    }
}
