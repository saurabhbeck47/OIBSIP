import java.util.Scanner;

class ATM{

    float Balance = 100000;
    int PIN = 4749;
    int transactions = 0;
    String transactionHistory = "";

    public void checkpin(){
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin ==PIN){
            menu();
        }
        else{
            System.out.println("Enter a vaid pin");
        }
    }


    public void menu(){
            System.out.println("\n~~~ Enter your Choice ~~~\n");
            System.out.println("1. Check Balance\n");
            System.out.println("2. Withdraw Money\n");
            System.out.println("3. Deposit Money\n");
            System.out.println("4. Transfer Money\n");
            System.out.println("5. Transaction History\n");

            System.out.println("6. Exit\n");

            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt(); 

            if(opt == 1){
                checkBalance();

            }

            else if(opt == 2){
                WithdrawMonry();
            }

            else if(opt == 3){
                depositMoney();
            }

            else if(opt == 4){
                TransferMoney();
            }
            else if(opt == 5){
                transHistory();
            }
            else if(opt == 6){
                return;
            }

            else{
                System.out.println("Enter a valid choise");
                menu();

            }
    }

    public void checkBalance(){
        System.out.println("Balance: " + Balance);
        menu();
    }

    public void WithdrawMonry(){
        System.out.println("Enter Amount to Withdraw");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if(amount>Balance){
            System.out.println("Insufficient Balance\n");

        } 
        else {
            Balance = Balance - amount;
            transactions++;
            System.out.println("Money withdrawn successfuly\n");
            String str = amount + " Rs Withdrawed\n";
            transactionHistory = transactionHistory.concat(str);

        }
        menu();
    }

    public void depositMoney(){
        System.out.println("Enter the Amount: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        transactions++;
        System.out.println("Money Deposited Successfuly\n");
        String str = amount + " Rs Deposited\n";

        transactionHistory = transactionHistory.concat(str);
        menu();


    }
    public void TransferMoney(){
        System.out.println("Enter Account number of reciever");
        Scanner ac = new Scanner(System.in);
        int accno = ac.nextInt();

        System.out.println("Enter Amount to Transfer");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if(amount>Balance){
            System.out.println("Insufficient Balance\n");

        } 
        else {
            Balance = Balance - amount;
            transactions++;
            System.out.println("Money transfered successfuly\n");
            String str = amount + " Rs Transfered\n";

            transactionHistory = transactionHistory.concat(str);

        }
        menu();
    }

    public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
        menu();

	}


}

public class ATMMachine {
    public static void main(String[] args){

        ATM obj = new ATM();
        obj.checkpin();

    }
    
}
