import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank b = new Bank();

        System.out.println("Welcome to the bank!");

        System.out.println("The withdrawal limit is: $" + b.getWithdrawalLimit());

        System.out.println();

        BankAccount ba = new BankAccount();
        ba.createBankAccount();

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        boolean carryOn = true;

        do {
            System.out.println("Which operation do you want to do?");
            System.out.println("= -> go to work");
            System.out.println("+ -> deposit money");
            System.out.println("- -> withdraw money");
            System.out.println(". -> see your balance");
            System.out.println("* -> bills");
            System.out.println("/ -> end day");

            System.out.println("How many actions you have left: " + ba.getActionPoints() + "\n");

            Scanner scanner = new Scanner(System.in);
            String operator = scanner.nextLine();

            switch (operator){
                case "=":
                    if(ba.getActionPoints() > 0) {
                        ba.work();
                        System.out.println("You received: $" + numberFormat.format(ba.getSalary()));
                        ba.useActionPoint();
                    } else {
                        System.out.println("You're out of action points");
                    }
                    break;
                case "+":
                    if(ba.getActionPoints() > 0) {  //condition to determine if you have any action points left
                        System.out.println("Choose amount: ");
                        double deposit = scanner.nextDouble();
                        ba.depositMoney(deposit);
                        System.out.println("Your balance is: $" + numberFormat.format(ba.getMoney()) + "\n");
                        ba.useActionPoint();
                    } else {
                        System.out.println("You're out of action points");
                    }
                    break;
                case "-":
                    if(ba.getActionPoints() > 0) {  //condition to determine if you have any action points left
                        System.out.println("Choose amount: ");
                        double withdraw = scanner.nextDouble();
                        ba.withdrawMoney(withdraw);
                        System.out.println("Your balance is: $" + numberFormat.format(ba.getMoney()) + "\n");
                        ba.useActionPoint();
                    } else {
                        System.out.println("You're out of action points");
                    }
                    break;
                case ".":
                    if(ba.getActionPoints() > 0) {  //condition to determine if you have any action points left
                        System.out.println("Your balance is: $" + numberFormat.format(ba.getMoney()) + "\n");
                        System.out.println("Your bank account balance is: $" + numberFormat.format(ba.getBankMoney()) + "\n");
                        ba.useActionPoint();
                    } else {
                        System.out.println("You're out of action points");
                    }
                    break;
                case "*":
                    if(ba.getActionPoints() > 0) {  //condition to determine if you have any action points left
                        System.out.println("You owe: $" + numberFormat.format(ba.getBill()) + "\n");
                        ba.useActionPoint();
                    } else {
                        System.out.println("You're out of action points");
                    }
                    break;
                case "/":
                    System.out.println("Sleeping...");
                    ba.passDay();
                    System.out.println("Your balance is: $" + numberFormat.format(ba.getMoney()) + "\n");
                    break;
                default:
                    System.out.println("error");
            }

        }while(carryOn = true);
    }
}
