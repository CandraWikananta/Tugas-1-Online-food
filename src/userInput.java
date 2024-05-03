import java.util.*;

public class userInput {
    private static Scanner scan = new Scanner(System.in);

    public static int getInteger(int min, int maks) {
        int input;
        while (true) {
            try {
                System.out.print("> ");
                input = scan.nextInt();
                scan.nextLine();
                if (input >= min && input <= maks) {
                    break;
                } else {
                    System.out.println("Input salah, silahkan masukkan kembali");

                }

            } catch (InputMismatchException e) {
                System.out.println("Input salah, silahkan masukkan kembali");
                scan.nextLine();
            }
        }
        return input;
    }

    public static String getString() {
        String input;
        while (true) {
            System.out.print("> ");
            input = scan.nextLine();
            if (input == null || input.length() == 0) {
                System.out.println("Input salah, silahkan masukkan kembali");
            } else {
                break;
            }
        }
        return input;
    }

    public static double getDouble() {
        double input;
        while (true) {
            try {
                System.out.print("> ");
                input = scan.nextDouble();
                scan.nextLine();
                return input; // Menambahkan pernyataan return untuk mengembalikan nilai input yang berhasil

            } catch (InputMismatchException d) {
                System.out.println("Input salah, silahkan masukkan kembali");
                scan.nextLine();
            }
        }
    }

    public static int getIntegerbiasa() {
        int input;
        while (true) {
            try {
                System.out.print("> ");
                input = scan.nextInt();
                scan.nextLine();
                return input;

            } catch (InputMismatchException e) {
                System.out.println("Input salah, silahkan masukkan kembali");
                scan.nextLine();
            }
        }
    }

    public static void hold() {
        System.out.println("");
        System.out.println("Tekan apapun untuk melanjutkan");
        System.out.print("> ");
        scan.nextLine();
    }

}
