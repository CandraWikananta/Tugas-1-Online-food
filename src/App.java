
public class App {
    public static void main(String[] args) {
        logIn();
    }

    public static void logIn() {
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            clearScreen();
            System.out.println("[] ================================================= []");
            System.out.println("||    Selamat datang di Pemesanan makanan online!    ||");
            System.out.println("[] ================================================= []");
            System.out.println("\nSilahkan Login terlebih dahulu.");
            System.out.println("-------------------------------------------------");
            System.out.print("Username : \n");
            String username = userInput.getString();
            System.out.print("Password : \n");
            String password = userInput.getString();

            if (username.equals(admin.usernameAdmin) && password.equals(admin.passwordAdmin)) {
                System.out.println("-------------------------------------------------");
                System.out.println("      * * Berhasil Login sebagai Admin! * *      ");
                System.out.println("-------------------------------------------------");
                isLoggedIn = true;
                userInput.hold();
                clearScreen();
                admin.adminMenu();
            } else if (username.equals(customer.usernameCustomer) && password.equals(customer.passwordCustomer)) {
                System.out.println("-------------------------------------------------");
                System.out.println("     * * Berhasil Login sebagai Customer! * *");
                System.out.println("-------------------------------------------------");
                isLoggedIn = true;
                userInput.hold();
                clearScreen();
                customer.menuCustomer();
            } else {
                System.out.println("Username dan Password salah, silahkan Login ulang!");
                userInput.hold();
                clearScreen();
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
