import java.util.ArrayList;

public class Restoran {
    static String namaResto;
    String alamat;
    private static ArrayList<ArrayList<String>> makanan = new ArrayList<>();
    private ArrayList<ArrayList<String>> minuman = new ArrayList<>();

    static int id = 1;

    // constructor untuk tambah restoran
    public Restoran(String namaResto, String alamat) {
        this.namaResto = namaResto;
        this.alamat = alamat;
    }

    public String getNamaResto() {
        return this.namaResto;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public ArrayList<ArrayList<String>> getMakanan() {
        return this.makanan;
    }

    public ArrayList<ArrayList<String>> getMinuman() {
        return this.minuman;
    }

    public void addMakanan(String namaMakanan, String hargaMakanan) {
        ArrayList<String> makananItem = new ArrayList<String>();
        makananItem.add(namaMakanan);
        makananItem.add(hargaMakanan);
        makanan.add(makananItem);
    }

    public void addMinuman(String namaMinuman, String hargaMinuman) {
        ArrayList<String> minumanItem = new ArrayList<String>();
        minumanItem.add(namaMinuman);
        minumanItem.add(hargaMinuman);
        minuman.add(minumanItem);
    }

    public static void printMakanan() {
        System.out.println("Daftar Makanan di " + namaResto + ":");

        // Loop melalui setiap ArrayList dalam makanan
        for (ArrayList<String> item : makanan) {
            // Loop melalui setiap item dalam ArrayList tersebut
            for (String makananItem : item) {
                System.out.println("Nama: " + makananItem);
            }
        }
    }
}
