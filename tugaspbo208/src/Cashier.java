import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayItems() {
        System.out.println("Daftar Barang:");
        for (Item item : items) {
            double subTotal = item.getPrice() * item.getQuantity();
            System.out.println("Kode: " + item.getCode() + ", Nama: " + item.getName() +
                    ", Harga: " + item.getPrice() + ", Jumlah: " + item.getQuantity() +
                    ", SubTotal: " + subTotal);
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void processPayment(double payment) {
        double total = getTotal();
        if (payment >= total) {
            double change = payment - total;
            System.out.println("Total Bayar: " + total);
            System.out.println("Dibayar: " + payment);
            System.out.println("Kembali: " + change);
        } else {
            System.out.println("Uang tidak cukup. Kurang: " + (total - payment));
        }
    }
}
