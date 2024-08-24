package entities;

public class product {
    public String name;
    public Double price;
    public int quantity;

    public double totalValueStock(){
        return price * quantity; 
    }

    public void addProducts(int quantity){
        this.quantity += quantity;
    }

    public void removeProducts(int quantity){
        this.quantity -=quantity;
    }

    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                + String.format("%.2f", totalValueStock());
    }

}
