package InstallmentGUIHEHE;

public class Items {
    private String itemName, itemPrice, paymentMethod;

    public Items(String itemName, String itemPrice, String paymentMethod) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.paymentMethod = paymentMethod;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return itemName + itemPrice + paymentMethod;
    }
}
