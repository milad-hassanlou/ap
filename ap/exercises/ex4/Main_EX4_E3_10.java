package ap.exercises.ex4;

public class Main_EX4_E3_10 {  //CashRegister
    private int balance;
    private String purchaseReceipt = "";
    private int totalPurchase = 0;


    public Main_EX4_E3_10(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraws(int amount) {
        balance -= amount;
        purchaseReceipt = purchaseReceipt + "\t" + amount;
        //Second way
        //purchaseReceipt = purchaseReceipt.concat(String.valueOf(amount));
        totalPurchase += amount;
    }

    public void printReceipt() {
        System.out.println("Receipt: " + purchaseReceipt);
        System.out.println("Total: " + totalPurchase);
    }
}
