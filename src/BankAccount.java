import java.util.Scanner;

public class BankAccount extends Bank{

    private double money;
    private String password;
    private String name;
    private String confirmPassword;
    Scanner scanner = new Scanner(System.in);

    public void createBankAccount() {

            System.out.println("Create account");
            System.out.println();
            System.out.print("Type your username: ");
            name = scanner.nextLine();

            System.out.print("Type your password: ");
            password = scanner.nextLine();

            System.out.print("Confirm password: ");
            confirmPassword = scanner.nextLine();

            if(password.equals(confirmPassword)) {
                if(password.length() >= 4) {
                    if(name.length() >= 4) {

                        System.out.println("Welcome " + name + "!");
                    } else {
                        throw new RuntimeException("The name must have at least 4 characters");
                    }
                } else {
                    throw new RuntimeException("The password must have at least 4 characters");
                }
            } else {
                throw new RuntimeException("The password doesn't match the confirmation");
            }
        }

    public void depositMoney(double amount) {
        money = money + amount;

        System.out.println("Type your account name: ");
        Scanner scanner = new Scanner(System.in);
        String nameInput = scanner.nextLine();
        System.out.println("Type your account password: ");
        String passwordInput = scanner.nextLine();

        if(!passwordInput.equals(getPassword()) || !nameInput.equals(getName())) { //verify the username and password
            throw new RuntimeException("Incorrect username or password");
        }
    }

    public void withdrawMoney(double amount) {
        if(amount <= money){
            if(amount <= 1200.00) {
                money = money - amount;
            } else {
                System.out.println("You can't withdraw more than " + getWithdrawalLimit());
            }
        } else {
            System.out.println("The withdrawal amount cannot be greater than your balance");
        }
    }

    //getters
    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}