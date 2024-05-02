public class ItemPesanan {
    private int idMenu;
    private String nama;
    private int harga;
    private int jumlah;

    // Konstruktor
    public ItemPesanan(String nama, int harga, int jumlah) {
        // this.idMenu = idMenu;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getter dan Setter
    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
