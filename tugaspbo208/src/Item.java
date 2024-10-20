public class Item {
    private double itemPrice;
    private String itemName;
    private String itemCode;
    private int itemQuantity;

    public Item() {}

    public Item(String code, String name, double price, int quantity) {
        this.itemCode = code;
        this.itemName = name;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }

    public double getPrice() {
        return itemPrice;
    }

    public String getCode() {
        return itemCode;
    }

    public String getName() {
        return itemName;
    }

    public int getQuantity() {
        return itemQuantity;
    }
}
