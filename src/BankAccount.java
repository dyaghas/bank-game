import java.util.Random;
import java.util.Scanner;

public class BankAccount extends Bank{

    private double money;
    private double bill;
    private int day;
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

            if(password.equals(confirmPassword)) {  //Verifies if the password is correct
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

        //verify the username and password
        if(!passwordInput.equals(getPassword()) || !nameInput.equals(getName())) {
            throw new RuntimeException("Incorrect username or password");
        }
    }

    public void withdrawMoney(double amount) {
        if(amount <= money){
            if(amount <= getWithdrawalLimit()) { //You can't withdraw more than the withdraw limit
                money = money - amount;
            } else {
                System.out.println("You can't withdraw more than " + getWithdrawalLimit());
            }
        } else {
            System.out.println("The withdrawal amount cannot be greater than your balance");
        }
    }

    private void createBill() { //random change of creating a bill after the day ends
        Random rand = new Random();

        bill += rand.nextDouble(121);
    }

    public void passDay() {
        money = money - bill;
        bill = 0;
        day++;

        System.out.println("Days passed: " + day);

        Random rand = new Random();

        for(int i = 0; i < 1; i++) {
            if(rand.nextInt(5) == 4) {
                createBill();
            }
        }

        System.out.println(bill);
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

    public double getBill() {
        return bill;
    }
}