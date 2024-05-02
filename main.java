import java.util.Scanner;

public class main {

    private static String usernameAdmin = "admin";
    private static String passwordAdmin = "admin";
    private static String usernameCustomer = "customer";
    private static String passwordCustomer = "customer";

    public static void main(String[] args) {

        Restoran restoran1 = new Restoran("Gacoan", "Sesetan");
        restoran1.addMakanan("Mie gacoan", "10500");
        restoran1.addMakanan("Udang Keju", "9000");
        restoran1.addMinuman("Es Teh", "5000");
        restoran1.addMinuman("Es Gobak Sodor", "10500");

        Restoran restoran2 = new Restoran("KFC", "Sesetan");
        restoran2.addMakanan("Ayam Krispy", "12000");
        restoran2.addMakanan("Chicken Nugget", "15000");
        restoran2.addMinuman("Lemon Tea", "8000");
        restoran2.addMinuman("Coca Cola", "9000");

        admin.restaurant.add(restoran1);
        admin.restaurant.add(restoran2);

        Scanner scan = new Scanner(System.in);

        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            systemCLS.clearScreen();
            System.out.println("[] ================================================= []");
            System.out.println("||    Selamat datang di Pemesanan makanan online!    ||");
            System.out.println("[] ================================================= []");
            System.out.println("\nSilahkan Login terlebih dahulu.");
            System.out.println("-------------------------------------------------");
            System.out.print("Username : ");
            String username = scan.nextLine();
            System.out.print("Password : ");
            String password = scan.nextLine();

            if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
                System.out.println("-------------------------------------------------");
                System.out.println("      * * Berhasil Login sebagai Admin! * *      ");
                System.out.println("-------------------------------------------------");                isLoggedIn = true;
                waitForInput(scan);
                systemCLS.clearScreen();
                admin.adminMenu();
            } else if (username.equals(usernameCustomer) && password.equals(passwordCustomer)) {
                System.out.println("-------------------------------------------------");
                System.out.println("     * * Berhasil Login sebagai Customer! * *");
                System.out.println("-------------------------------------------------");
                isLoggedIn = true;
                waitForInput(scan);
                systemCLS.clearScreen();
                customer.menuCustomer();
            } else {
                System.out.println("Username dan Password salah, silahkan Login ulang!");
                waitForInput(scan);
                systemCLS.clearScreen();

            }
        }
    }

    public static void waitForInput(Scanner scan) {
        System.out.println("Tekan tombol ENTER untuk lanjut");
        scan.nextLine();
    }
}
