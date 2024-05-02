import java.util.*;

public class userInput {
    private static Scanner scan = new Scanner(System.in);

    public static int getInteger(int min, int maks) {
        int input;
        while (true) {
            try {
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
            input = scan.next();
            if (input == null && input.length() == 0) {
                System.out.println("Input salah, silahkan masukkan kembali");
            } else {
                break;
            }
        }
        return input;
    }

    public static double getDouble(double min, double maks) {
        double input;
        while (true) {
            try {
                input = scan.nextDouble();
                scan.nextLine();
                if (input <= min && input >= maks) {
                    break;
                } else {
                    System.out.println("Input salah, silahkan masukkan kembali");

                }

            } catch (InputMismatchException d) {
                System.out.println("Input salah, silahkan masukkan kembali");
                scan.nextLine();
            }
        }
        return input;
    }

}
