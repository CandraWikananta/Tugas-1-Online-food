# Tugas 1 Mata Kuliah Pemrograman Basis Objek - Program Membeli Makanan Online Berbasis Command Line

Program membeli makanan online berbasis command line ini kami bangun dengan bahasa Java. Program ini memanfaatkan konsep objek dalam bahasa pemrograman Java untuk mengorganisasi berbagai fitur dan fungsi yang diperlukan. Program ini juga dilengkapi dengan input validasi pada class Input untuk memastikan pengguna memberikan input yang sesuai dengan yang dibutuhkan oleh program.

Di bawah ini adalah deskripsi program, penjelasan dari bagaimana program akan dijalankan, dan UML dari program ini. Untuk deskripsi kode lebih lengkap dapat dilihat pada kode program yang sudah dicommit sebelumnya (sudah disertakan beberapa comment untuk membantu dalam mengerti cara kerja program). Selamat menyimak

## Daftar Isi

- [Tugas 1](#tugas-1-mata-kuliah-pemrograman-basis-objek---program-membeli-makanan-online-berbasis-command-line)
  - [Daftar Isi](#daftar-isi)
  - [Creator](#creator)
  - [UML](#desain-uml)
  - [Batasan](#batasan-program)
  - [Aplikasi Yang DIgunakan](#aplikasi-yang-digunakan)
    - [VSCode](#visual-studio-code)
    - [Java Extension Pack](#extension-pack-for-java)
  - [Alur](#alur-program)
    - [Login](#login)
    - [Admin](#admin)
    - [Customer](#customer)
  - [Penutup](#penutup)

## Creator

Pembuat program ini :
Putu Devasya Aditya Widyadana - 2305551071
I Nyoman Gede Candra Wikananta - 2305551065

## Desain UML

Diagram UML adalah cara untuk memvisualisasikan sistem dan perangkat lunak menggunakan Unified Modeling Language (UML). Diagram UML digunakan untuk memahami desain, arsitektur kode, dan usulan implementasi sistem perangkat lunak yang kompleks. Berikut adalah diagram UML dari program yang telah kami buat

![UML](/gambar/UMLRestoOnline.jpg)

## Batasan Program

Adapun batasan program yang sudah kami buat, antara lain :

- Program ini hanya melayani dua tipe pengguna, yaitu src.customer dan src.admin
- Username dan Password ditulis di dalam kode langsung
- Hanya tersedia satu bahasa, yaitu bahasa Indonesia

## Aplikasi Yang Digunakan

Adapun beberapa aplikasi yang kami gunakan untuk pembuatan program ini yaitu sebagai berikut

### Visual Studio Code

Visual Studio Code (VS Code) adalah editor kode sumber gratis yang dibuat oleh Microsoft untuk sistem operasi Windows, macOS, dan Linux. VS Code adalah editor kode sumber yang ringan dan kuat, dan dapat digunakan untuk membuat kode dalam bahasa pemrograman apa pun.

### Extension Pack For Java

Paket Ekstensi untuk Java adalah kumpulan ekstensi populer yang dapat membantu menulis, menguji, dan men-debug aplikasi Java dalam Visual Studio Code

## Alur Program

Adapun alur dari program yang telah kami buat sebagai berikut :

### Login

![login](/gambar/login.jpg "login")

Penggunaan program diawali dengan login pengguna. Terdapat dua jenis penggguna yaitu src.customer dan src.admin .Pengguna dapat login ke dalam program ini dengan username dan password yang telah kami set di dalam program ini. Berikut adalah username dan passowrd untuk masing - masing pengguna.

**Customer**
`Username   : src.customer`
`Password   : src.customer`

**Admin**
`Username   : src.admin`
`Password   : src.admin`

![loginSuccess](/gambar/loginSuccess.jpg "loginSuccess")

Jika pengguna memasukkan username dan password yang benar, maka pengguna akan diarahkan ke salah satu tipe user pada aplikasi ini.

### Admin

1. **Menu Utama**

Setelah melakukan login dengan username dan password yang sesuai, maka pengguna akan diarahakan ke menu src.admin. Berikut adalah tampilan awal menu src.admin

![Menu utama](/gambar/menuUtamaAdm.jpg "Menu utama")

2. **Lihat src.Restoran**

![Lihat restoran](/gambar/lihatRestoOp.jpg "Lihat restoran")

Jika pengguna memilih menu lihat restoran, maka tampilan menu pertama adalah list restoran yang sudah ditambahkan sebelumnya. Selanjutnya pengguna akan memilih ID restoran berapa yang ingin ditampilkan menunya.

![List Menu](/gambar/lihatRestoAftInput.jpg "List menu")

Setelah pengguna memilih ID src.Restoran, maka akan tampil list menu yang telah ditambahkan sebelumnya seperti pada contoh gambar di atas. Setelah selesai melihat, pengguna hanya cukup menekan enter untuk kembali ke halaman utama src.admin.

3. **Tambah src.Restoran**

![Tambah menu](/gambar/tambahRRestoOp.jpg "Tambah menu")

Jika pengguna memilih menu tambah restoran, maka tampilan menu pertama adalah pengguna diminta untuk memasukkan nama restoran dan alamat restoran yang ingin dibuat.

![TambahF-D](/gambar/tambahMenu.jpg "TambahF-D")

Setelah memasukkan nama restoran dan alamat restoran, user akan diperkian pilihan untuk menambahkan menu makanan ataupun menu minuman

![selesaiTambahMenu](/gambar/tambahMenuDone.jpg "Selesai tambah menu")

Setelah memilih ingin menambah menu makanan atau minuman, user akan diminta untuk menlengkapi data untuk menu seperti nama menu dan harga menu. Kita dapat menambahkan menu makanan dan minuman berkai - kali tergantung keinginan kita

![selesaiTambahResto](/gambar/tambahRestoDone.jpg "Selesai tambah resto")

Jika user sudah tidak mau menambahkan menu, maka data restoran akan disimpan berserta data menu yang telah dimasukkan.

3. **Hapus src.Restoran**

![hapusResto](/gambar/hapusRestoOp.jpg "Hapus resto")

Jika pengguna memilih menu hapus restoran, maka tampilan menu pertama adalah list restoran yang sudah ditambahkan sebelumnya seperti gambar di atas. Selanjutnya pengguna akan memilih ID restoran berapa yang akan dihapus.

![konfirmHapusResto](/gambar/hapusRestokonfirm.jpg "Konfirmasi hapus resto")

Setelah memilih ID Resto berapa yang akan dihaps, akan tampil data restoran beserta pesan konfirmasi penghapusan. Jika kita melakukan penghapusan maka semua data restoran dengan ID src.Restoran yang kita pilih akan hilang datanya.

![selesaiHapusResto](/gambar/hapusRestoDone.jpg "Selesai hapus resto")

Jika user memilih untuk mengonfirmasi penghapusan, maka restoran tersebut akan terhapus. Sedangkan jika user memilih batal, maka tampilan akan kembali ke menu awal src.admin.

4 **Kembali Ke Menu Login**

![kembaliKeLogin](/gambar/kembaliKeLogin.jpg "Kembali ke login")

Jika user memilih menu 'kembali ke login', maka akan tampil pesan seperti gambar di atas. Selelah pengguna menekan enter, maka user akan kembali ke menu login.

### Customer

1. **Login Customer**

Untuk Log in ke dalam menu src.customer, kita harus memasukkan username "src.customer" dan password "src.customer" di halaman log in terlebih dahulu.

![LoginCustomer](/gambar/LoginCustomer.png "Login sebagai Customer")

2. **Halaman Utama Customer**

Setelah melakukan login dengan username dan password yang sesuai, maka pengguna akan diarahakan ke menu src.customer. Berikut adalah tampilan awal menu src.admin

![menu src.customer](/gambar/menuCustomer.png "Menu Utama Customer")

3. **Lihat src.Restoran**

![Lihat src.Restoran](/gambar/lihatRestoranCust.png "Lihat src.Restoran")

Jika pengguna memilih menu lihat restoran, maka tampilan menu pertama adalah list restoran yang sudah ditambahkan sebelumnya. Selanjutnya pengguna akan memilih ID restoran berapa yang ingin ditampilkan menunya.

![Lihat Menu Resto](/gambar/menuRestoranCust.png "Menu src.Restoran")

Setelah pengguna memilih ID src.Restoran, maka akan tampil list menu yang telah ditambahkan sebelumnya seperti pada contoh gambar di atas. Setelah selesai melihat, pengguna hanya cukup menekan enter untuk kembali ke halaman utama src.admin.

4. **Melakukan src.Pesanan**

Jika pengguna memilih untuk melakukan pesanan, maka akan ditampilkan menu daftar restoran terlebih dahulu, kemudian pengguna dapat memilih dari restoran mana yang mau dipesan.

![Daftar src.Restoran](/gambar/daftarRestoranCust.png "Daftar src.Restoran")

Setelah pengguna memilih restoran, akan ditampilkan list menu yang ada di dalam restoran tersebut seperti gambar di bawah ini.

![Menu Resto](/gambar/melakukanPesanan.png "Melakukan src.Pesanan")

Kemudian pengguna dapat memilih diantara makanan/minuman yang mau dipesan. lalu pengguna harus memasukkan nomor makanan/minuman yang mau dipesan dan jumlah nya berapa.

![src.Pesanan](/gambar/melakukanPesanan2.png "Menambah src.Pesanan")

Setelah itu pengguna akan ditanyakan jika ingin melakukan pesanan lagi atau tidak, jika iya pengguna akan diminta untuk memilih nomor makanan/minuman lagi dan jumlahnya. Jika tidak maka akan ditanyakan jarak rumah dari Resto dan akan dihitung harga ongkir serta total harga pesanan.

![Selesai src.Pesanan](/gambar/selesaiPesanan.png "Selesai src.Pesanan")

Pengguna cukup untuk menekankan tombol enter untuk lanjut setelah selesai melakukan pesanan.

5. **Riwayat src.Pesanan**

Ketika pengguna sudah selesai melakukan pemesanan, kita bisa melihat riwayat pemesanan yang telah pengguna lakukan. Berikut adalah tampilan menu dari riwayat pemesanan.

![Riwayat src.Pesanan](/gambar/riwayatPesanan.png "Riwayat src.Pesanan")

## Penutup

Sekian program membeli makanan online berbasis command line dari kami. Mohon maaf apabila ada kesalahan yang terjadi dalam program
Terima Kasih
