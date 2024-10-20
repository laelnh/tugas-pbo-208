import java.util.Scanner;

public class App {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        Cashier cashier = new Cashier();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Tampilkan Transaksi");
            System.out.println("4. Proses Pembayaran");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next();
                    System.out.print("Masukkan nama barang: ");
                    String addName = scanner.next();
                    System.out.print("Masukkan harga barang: ");
                    double addPrice = scanner.nextDouble();
                    System.out.print("Masukkan jumlah barang: ");
                    int quantity = scanner.nextInt();
                    cashier.addItem(addPrice, addCode, addName, quantity);
                    break;
                case 2:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String removeCode = scanner.next();
                    cashier.removeItem(removeCode);
                    break;
                case 3:
                    // Menampilkan daftar item yang telah ditambahkan
                    cashier.displayItems();
                    System.out.println("Total harga seluruh barang: " + cashier.getTotal());

                    // Tambahkan ini agar program menunggu input sebelum kembali ke menu
                    System.out.println("Tekan enter untuk kembali ke menu...");
                    scanner.nextLine(); // Menangkap input enter
                    scanner.nextLine(); // Sekali lagi untuk memastikan enter tertangkap
                    break;
                case 4:
                    if (cashier.getTotal() == 0) {
                        System.out.println("Tidak ada barang yang dibeli.");
                        break;
                    }
                    System.out.println("Total harga seluruh barang: " + cashier.getTotal());
                    System.out.print("Masukkan jumlah pembayaran: ");
                    double payment = scanner.nextDouble();
                    cashier.processPayment(payment);

                    // Jika pembayaran sudah berhasil, keluar dari loop
                    if (payment >= cashier.getTotal()) {
                        System.out.println("Terima kasih telah berbelanja.");
                        return; // Keluar setelah pembayaran berhasil
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    return; // Mengakhiri program
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
