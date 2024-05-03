import java.util.ArrayList;

public class Pesanan {
    private ArrayList<Restoran> daftarRestoran;
    private int idRestoran;
    private ArrayList<ItemPesanan> makananPesanan;
    private ArrayList<ItemPesanan> minumanPesanan;
    private int jarak;
    private int totalHarga;

    public Pesanan(int idRestoran, ArrayList<ItemPesanan> makananPesanan, ArrayList<ItemPesanan> minumanPesanan, int jarak, int totalHarga, ArrayList<Restoran> daftarRestoran) {
    this.idRestoran = idRestoran;
    this.makananPesanan = makananPesanan;
    this.minumanPesanan = minumanPesanan;
    this.jarak = jarak;
    this.totalHarga = totalHarga;
    this.daftarRestoran = daftarRestoran;
}

    public ArrayList<Restoran> getDaftarRestoran() {
        return daftarRestoran;
    }
    

    public int getIdRestoran() {
        return idRestoran;
    }

    public String getNamaRestoran(int idRestoran) {
        for (Restoran restoran : daftarRestoran) {
            if (restoran.getIdRestoran() == idRestoran) {
                return restoran.getNamaResto();
            }
        }
        return "src.Restoran tidak ditemukan";
    }

    public void setIdRestoran(int idRestoran) {
        this.idRestoran = idRestoran;
    }

    public ArrayList<ItemPesanan> getMakananPesanan() {
        return makananPesanan;
    }

    public void setMakananPesanan(ArrayList<ItemPesanan> makananPesanan) {
        this.makananPesanan = makananPesanan;
    }

    public ArrayList<ItemPesanan> getMinumanPesanan() {
        return minumanPesanan;
    }

    public void setMinumanPesanan(ArrayList<ItemPesanan> minumanPesanan) {
        this.minumanPesanan = minumanPesanan;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}
