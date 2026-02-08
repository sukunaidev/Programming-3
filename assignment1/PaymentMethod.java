public abstract class PaymentMethod implements Payable
{
    protected String accountHolder;
    protected double balance;
    static int totalTransactions;

   public PaymentMethod(String accountHolder,  double balance)
   {
     this.accountHolder = accountHolder;
     this.balance = balance;
   }
   
   abstract void validateAccount();
}