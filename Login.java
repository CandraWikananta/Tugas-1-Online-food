import java.util.Scanner;

public class Login {

    private static String usernameAdmin = "admin";
    private static String passwordAdmin = "admin";
    private static String usernameCustomer = "customer";
    private static String passwordCustomer = "customer";

    public static void logIn() {
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
                System.out.println("-------------------------------------------------");
                isLoggedIn = true;
                userInput.hold();
                systemCLS.clearScreen();
                admin.adminMenu();
            } else if (username.equals(usernameCustomer) && password.equals(passwordCustomer)) {
                System.out.println("-------------------------------------------------");
                System.out.println("     * * Berhasil Login sebagai Customer! * *");
                System.out.println("-------------------------------------------------");
                isLoggedIn = true;
                userInput.hold();
                systemCLS.clearScreen();
                customer.menuCustomer();
            } else {
                System.out.println("Username dan Password salah, silahkan Login ulang!");
                userInput.hold();
                ;
                systemCLS.clearScreen();
            }
        }
    }

}
