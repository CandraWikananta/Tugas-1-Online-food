public class App {
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

        logIn();
    }

    public static void logIn(){
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
                System.out.println("-------------------------------------------------");                isLoggedIn = true;
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
