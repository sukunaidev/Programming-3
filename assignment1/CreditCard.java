public class CreditCard extends PaymentMethod{
    private double creditLimit;

    
    public CreditCard(String accountHolder, double balance){
        super(accountHolder,balance);
        
    }

    @Override
    public void validateAccount() 
    {
        if (accountHolder == null || accountHolder.isEmpty()) 
        {
            System.out.println("Invalid account holder.");
        } else if (balance < 0) 
        {
            System.out.println("Negative balance.");
        }

    }

    @Override
    public void processPayment(double amount)
    {
         if(amount > balance + creditLimit)
        {
            System.out.println("Transaction Declined.");
        }
        else
        {
            balance -=amount;
            totalTransactions++;
        }
    }
    @Override
    public String getPaymentStatus() 
    {
    return "Active";
    }

}