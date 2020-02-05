import java.util.Scanner;

public class AccountHolderTest{

    public static void main(String[] args){
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        double balance = 100;
        double fund = 0;

        // Start object
        AccountHolder ah1 = new AccountHolder(balance);

        // Set initial balance
        ah1.setBalance(balance);

        // Do a deposit
        ah1.deposit(fund);

        // Do a withdrawl
        ah1.withdraw(fund);

        // Display ending balance with interest
        ah1.monthlyInterest();

        sc.close();
    }
}