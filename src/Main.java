import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank b = new Bank();

        System.out.println("Welcome to the bank!");

        System.out.println("The withdrawal limit is: $" + b.getWithdrawalLimit());

        System.out.println();
        System.out.println("Please create an account");

        BankAccount ba = new BankAccount();
        ba.createBankAccount();

        boolean carryOn = true;

        do {
            System.out.println("Which operation do you want to do?");
            System.out.println("+ -> deposit money");
            System.out.println("- -> withdraw money");
            System.out.println(". -> see your balance");
            System.out.println("* -> bills");
            System.out.println("/ -> end day");

            Scanner scanner = new Scanner(System.in);
            String operator = scanner.nextLine();

            switch (operator){
                case "+":
                    System.out.println("Choose amount: ");
                    double deposit = scanner.nextDouble();
                    ba.depositMoney(deposit);
                    System.out.println("Your account balance is: $" + ba.getMoney() + "\n");
                    break;
                case "-":
                    System.out.println("Choose amount: ");
                    double withdraw = scanner.nextDouble();
                    ba.withdrawMoney(withdraw);
                    System.out.println("Your account balance is: $" + ba.getMoney() + "\n");
                    break;
                case ".":
                    System.out.println("Your account balance is: $" + ba.getMoney() + "\n");
                    break;
                case "*":
                    System.out.println("You owe: $" + ba.getBill() + "\n");
                    break;
                case "/":
                    System.out.println("Sleeping...");
                    ba.passDay();
                    System.out.println("Your account balance is: $" + ba.getMoney() + "\n");
                    break;
                default:
                    System.out.println("error");
            }

        }while(carryOn = true);
    }
}
