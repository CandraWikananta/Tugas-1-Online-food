import java.util.Scanner;

public class main {

    private static String usernameAdmin = "admin";
    private static String passwordAdmin = "admin";
    private static String usernameCustomer = "customer";
    private static String passwordCustomer = "customer";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isLoggedIn = false;
        while(!isLoggedIn){
            systemCLS.clearScreen();
            System.out.println("Selamat datang di Pemesanan makanan online!");
            System.out.println("-------------------------------------------------");
            System.out.println("Silahkan Login terlebih dahulu.");
            System.out.print("Username : ");
            String username = scan.nextLine();
            System.out.print("Password : ");
            String password = scan.nextLine();

            if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
                System.out.println("Berhasil Login sebagai Admin!");
                isLoggedIn = true;
                waitForInput(scan);
                systemCLS.clearScreen();
            }
            else if (username.equals(usernameCustomer) && password.equals(passwordCustomer)){
                System.out.println("-------------------------------------------------");
                System.out.println("     * * Berhasil Login sebagai Customer! * *");
                System.out.println("-------------------------------------------------");
                isLoggedIn = true;
                waitForInput(scan);
                systemCLS.clearScreen();
                customer.menuCustomer();
            }
            else{
                System.out.println("Username dan Password salah, silahkan Login ulang!");
                waitForInput(scan);
                systemCLS.clearScreen();
                
            }
        }
    }

    public static void waitForInput(Scanner scan){
        System.out.println("Tekan tombol ENTER untuk lanjut");
        scan.nextLine();
    }
}
