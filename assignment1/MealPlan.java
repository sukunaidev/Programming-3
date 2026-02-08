public class MealPlan extends PaymentMethod
{
    public MealPlan(String accountHolder, double balance)
    {
        super(accountHolder, balance);
    }




    @Override
     public void validateAccount()
     {
        if(balance > 0)
        {
            System.out.println("Sufficient Funds. Your account balance is: " + balance);
        }
        else if(balance < 0)
        {
            System.out.println("Negative balance. Your account balance is: " + balance);
        }


     }

     @Override
     public void processPayment(double amount)
     {
        validateAccount();
        if(balance >= amount)
        {
            balance -=amount;
            totalTransactions++;
             System.out.println("Processing Transaction. Your balance is:" + balance);
        }
        
        else if(balance < amount)
        {
             System.out.println("Insufficent balance. Your account balance is: " + balance);
        }


     }
         @Override
public String getPaymentStatus() {
    return "Active";}
}

