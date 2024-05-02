import java.util.ArrayList;

public class Restoran {
    private String namaResto; // Ubah menjadi variabel non-statis
    private String alamat;
    private ArrayList<ArrayList<String>> makanan = new ArrayList<>();
    private ArrayList<ArrayList<String>> minuman = new ArrayList<>();

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
}
