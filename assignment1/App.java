import java.util.ArrayList;

public class App
{
public static void main(String[] args) {
    ArrayList<Payable> paymentQueue = new ArrayList<>();
    paymentQueue.add(new CreditCard("Mister Meow",400.0));
    paymentQueue.add(new MealPlan("Mister Meow",5.0));

    for(int i=0; i<paymentQueue.size(); i++)
    {
        paymentQueue.get(i).processPayment(50.0);
    }
    System.out.println("Total transactions: " + PaymentMethod.totalTransactions);
}
}
