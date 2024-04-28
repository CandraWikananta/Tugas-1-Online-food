import java.util.ArrayList;

public class Restoran {
    String namaResto;
    String alamat;
    private ArrayList<ArrayList<String>> makanan = new ArrayList<>();
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
        ArrayList<String> makanan = new ArrayList<String>();
        makanan.add(namaMakanan);
        makanan.add(hargaMakanan);

    }

    public void addMinuman(String namaMinuman, String hargaMinuman) {
        ArrayList<String> minuman = new ArrayList<String>();
        minuman.add(namaMinuman);
        minuman.add(hargaMinuman);

    }
}
