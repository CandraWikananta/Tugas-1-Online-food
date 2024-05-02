import java.util.Scanner;

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

        Login.logIn();
    }
}
