# Tugas 1 Mata Kuliah Pemrograman Basis Objek - Program Membeli Makanan Online Berbasis Command Line

Program membeli makanan online berbasis command line ini kami bangun dengan bahasa Java. Program ini memanfaatkan konsep objek dalam bahasa pemrograman Java untuk mengorganisasi berbagai fitur dan fungsi yang diperlukan. Program ini juga dilengkapi dengan input validasi pada class Input untuk memastikan User memberikan input yang sesuai dengan yang dibutuhkan oleh program.

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

- Program ini hanya melayani dua tipe User, yaitu customer dan admin
- Username dan Password ditulis di dalam kode langsung
- Hanya tersedia satu bahasa, yaitu bahasa Indonesia
- Program ini hanya menggunakan bahasa indonesia
- Program ini hanya berbasis Command Line

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

Penggunaan program diawali dengan login User. Terdapat dua jenis penggguna yaitu customer dan admin .User dapat login ke dalam program ini dengan username dan password yang telah kami set di dalam program ini. Berikut adalah username dan passowrd untuk masing - masing User.

**Customer**
`Username   : customer`
`Password   : customer`

**Admin**
`Username   : admin`
`Password   : admin`

![loginSuccess](/gambar/loginSuccess.jpg "loginSuccess")

Jika User memasukkan username dan password yang benar, maka User akan diarahkan ke salah satu tipe user pada aplikasi ini.

### Admin

1. **Menu Utama**

Setelah melakukan login dengan username dan password yang sesuai, maka User akan diarahakan ke menu admin. Berikut adalah tampilan awal menu admin

![Menu utama](/gambar/menuUtamaAdm.jpg "Menu utama")

2. **Lihat Restoran**

![Lihat restoran](/gambar/lihatRestoOp.jpg "Lihat restoran")

Jika User memilih menu lihat restoran, maka tampilan menu pertama adalah list restoran yang sudah ditambahkan sebelumnya. Selanjutnya User akan memilih ID restoran berapa yang ingin ditampilkan menunya.

![List Menu](/gambar/lihatRestoAftInput.jpg "List menu")

Setelah User memilih ID Restoran, maka akan tampil list menu yang telah ditambahkan sebelumnya seperti pada contoh gambar di atas. Setelah selesai melihat, User hanya cukup menekan enter untuk kembali ke halaman utama admin.

3. **Tambah Restoran**

![Tambah menu](/gambar/tambahRRestoOp.jpg "Tambah menu")

Jika User memilih menu tambah restoran, maka tampilan menu pertama adalah User diminta untuk memasukkan nama restoran dan alamat restoran yang ingin dibuat.

![TambahF-D](/gambar/tambahMenu.jpg "TambahF-D")

Setelah memasukkan nama restoran dan alamat restoran, user akan diperkian pilihan untuk menambahkan menu makanan ataupun menu minuman

![selesaiTambahMenu](/gambar/tambahMenuDone.jpg "Selesai tambah menu")

Setelah memilih ingin menambah menu makanan atau minuman, user akan diminta untuk menlengkapi data untuk menu seperti nama menu dan harga menu. Kita dapat menambahkan menu makanan dan minuman berkai - kali tergantung keinginan kita

![selesaiTambahResto](/gambar/tambahRestoDone.jpg "Selesai tambah resto")

Jika user sudah tidak mau menambahkan menu, maka data restoran akan disimpan berserta data menu yang telah dimasukkan.

3. **Hapus Restoran**

![hapusResto](/gambar/hapusRestoOp.jpg "Hapus resto")

Jika User memilih menu hapus restoran, maka tampilan menu pertama adalah list restoran yang sudah ditambahkan sebelumnya seperti gambar di atas. Selanjutnya User akan memilih ID restoran berapa yang akan dihapus.

![konfirmHapusResto](/gambar/hapusRestokonfirm.jpg "Konfirmasi hapus resto")

Setelah memilih ID Resto berapa yang akan dihaps, akan tampil data restoran beserta pesan konfirmasi penghapusan. Jika kita melakukan penghapusan maka semua data restoran dengan ID Restoran yang kita pilih akan hilang datanya.

![selesaiHapusResto](/gambar/hapusRestoDone.jpg "Selesai hapus resto")

Jika user memilih untuk mengonfirmasi penghapusan, maka restoran tersebut akan terhapus. Sedangkan jika user memilih batal, maka tampilan akan kembali ke menu awal admin.

4 **Kembali Ke Menu Login**

![kembaliKeLogin](/gambar/kembaliKeLogin.jpg "Kembali ke login")

Jika user memilih menu 'kembali ke login', maka akan tampil pesan seperti gambar di atas. Selelah User menekan enter, maka user akan kembali ke menu login.

### Customer

1. **Login Customer**

Untuk Log in ke dalam menu customer, kita harus memasukkan username "customer" dan password "customer" di halaman log in terlebih dahulu.

![LoginCustomer](/gambar/LoginCustomer.png "Login sebagai Customer")

2. **Halaman Utama Customer**

Setelah melakukan login dengan username dan password yang sesuai, maka User akan diarahakan ke menu customer. Berikut adalah tampilan awal menu admin

![menu customer](/gambar/menuCustomer.png "Menu Utama Customer")

3. **Lihat Restoran**

![Lihat Restoran](/gambar/lihatRestoranCust.png "Lihat Restoran")

Jika User memilih menu lihat restoran, maka tampilan menu pertama adalah list restoran yang sudah ditambahkan sebelumnya. Selanjutnya User akan memilih ID restoran berapa yang ingin ditampilkan menunya.

![Lihat Menu Resto](/gambar/menuRestoranCust.png "Menu Restoran")

Setelah User memilih ID Restoran, maka akan tampil list menu yang telah ditambahkan sebelumnya seperti pada contoh gambar di atas. Setelah selesai melihat, User hanya cukup menekan enter untuk kembali ke halaman utama admin.

4. **Melakukan Pesanan**

Jika User memilih untuk melakukan pesanan, maka akan ditampilkan menu daftar restoran terlebih dahulu, kemudian User dapat memilih dari restoran mana yang mau dipesan.

![Daftar Restoran](/gambar/daftarRestoranCust.png "Daftar Restoran")

Setelah User memilih restoran, akan ditampilkan list menu yang ada di dalam restoran tersebut seperti gambar di bawah ini.

![Menu Resto](/gambar/melakukanPesanan.png "Melakukan Pesanan")

Kemudian User dapat memilih diantara makanan/minuman yang mau dipesan. lalu User harus memasukkan nomor makanan/minuman yang mau dipesan dan jumlah nya berapa.

![Pesanan](/gambar/melakukanPesanan2.png "Menambah Pesanan")

Setelah itu User akan ditanyakan jika ingin melakukan pesanan lagi atau tidak, jika iya User akan diminta untuk memilih nomor makanan/minuman lagi dan jumlahnya. Jika tidak maka akan ditanyakan jarak rumah dari Resto dan akan dihitung harga ongkir serta total harga pesanan.

![Selesai Pesanan](/gambar/selesaiPesanan.png "Selesai Pesanan")

User cukup untuk menekankan tombol enter untuk lanjut setelah selesai melakukan pesanan.

5. **Riwayat Pesanan**

Ketika User sudah selesai melakukan pemesanan, kita bisa melihat riwayat pemesanan yang telah User lakukan. Berikut adalah tampilan menu dari riwayat pemesanan.

![Riwayat Pesanan](/gambar/riwayatPesanan.png "Riwayat Pesanan")

## Penutup

Sekian program membeli makanan online berbasis command line dari kami. Mohon maaf apabila ada kesalahan yang terjadi dalam program
Terima Kasih
