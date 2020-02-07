import java.util.Scanner;

public class AccountHolder{

    // Instance fields
    double balance;
    Scanner sc = new Scanner(System.in);
    static double annualInterestRate = .04;

    public AccountHolder(double fund){
        // Set member field to starter value
        balance = fund < 0 ? 0: fund;
    }

     /*
     *  Set initial account balance
     */
    public void setBalance(double balance){
        
        // Prompt to enter balance
        System.out.print("Enter your starting balance: ");
        balance = sc.nextDouble();
        
        // WIll loop until balance is greater than zero
        while(balance <= 0){
            System.out.println("ERROR: Balance cannot be equal to or less than $0.00.");
            System.out.print("Enter your starting balance: ");
            balance = sc.nextDouble();
        }

        // Sets balance to entered value
        this.balance = balance;
        System.out.println();
    }
    
    /*
     *  Return current account balance
     */
    public double getBalance(){
        return balance;
    }

    /*
     *  Calculates balance after 4% interest 
     */
    public void monthlyInterest(){

        // Add interest rate amount to balance (for the month)
        balance += balance * (annualInterestRate/12.0);
        System.out.printf("Expected balance after monthly interest: "+"$%.2f",balance);
        System.out.println("\n");
    }

    /* 
     * Accept balance arg. to boost (update) the current balance
     */
    public void deposit(double fund){

        // Prompts for deposit value entry
        System.err.print("Enter amount you wish to deposit: ");
        fund = sc.nextDouble();

        // Adds funds (deposit) to balance and sets as new balance
        this.balance += fund;
        System.out.printf("New balance is: "+"$%.2f",balance);
        System.out.println("\n");
    }
    
    /* 
     * Discount (subtract) from balance up to a limit
     * Warns user if they have reached the limit
     */
    public void withdraw(double fund){

        /* 
         * Check current balance with current local value and update the reduction
         * Not allowed to go below limit of $50
         */
        if(balance < 50){
            System.out.println("ERROR: Cannot withdraw funds if less than $50.00 are available.");
            System.out.printf("Balance is: "+"$%.2f",balance);
            System.out.println("\n");
            return;
        }

        // Prompts for withdrawl value entry
        System.err.print("Enter amount you wish to withdraw: ");
        fund = sc.nextDouble();
        
        // Attempt to withdraw funds
        balance = balance - fund;

        // Checks if dips below minimum
        if(balance < 50){
            System.out.println("ERROR: Accounts must have a $50.00 minimum balance.");
            System.out.println("Funds will be unaltered; returning to main menu.");
            this.balance += fund;
            System.out.println("\n");
            return;
        }
        // Completes if valid and present ending balance
        else{
            System.out.printf("Withdrew: "+"$%.2f",fund);
            System.out.printf("\nNew balance is: "+"$%.2f",balance);
            System.out.println("\n");
        }

    }

}