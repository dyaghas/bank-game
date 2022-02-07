import java.util.Random;
import java.util.Scanner;

public class BankAccount extends Bank{

    private double money = 1200.00;
    private double bankMoney = 0;
    private double bill;
    private double salary;
    private int actionPoints = 3;
    private int day;
    private String name;
    Scanner scanner = new Scanner(System.in);

    public void createBankAccount() {
            System.out.print("Choose your name: ");
            name = scanner.nextLine();
        }

    public void depositMoney(double amount) {
            if (amount <= money) {
                bankMoney = bankMoney + amount;
                money = money - amount;
            }
    }

    public void withdrawMoney(double amount) {
            if (amount <= bankMoney) {
                if (amount <= getWithdrawalLimit()) { //You can't withdraw more than the withdraw limit
                    money = money + amount;
                    bankMoney = bankMoney - amount;
                } else {
                    System.out.println("You can't withdraw more than " + getWithdrawalLimit());
                }
            } else {
                System.out.println("The withdrawal amount cannot be greater than your account balance");
            }
    }

    public void passDay() {
        money = money - bill; //Pay bills automatically
        bill = 0;
        day++;

        System.out.println("Days passed: " + day);

        Random rand = new Random();

        for(int i = 0; i < 1; i++) {    //random chance of creating a bill
            if(rand.nextInt(5) == 4) {
                setBill();
            }
        }
        System.out.println(bill);

        resetActionPoints();
    }

    protected void work() {
        setSalary();
        money = money + salary;
    }

    public void useActionPoint() {
        actionPoints = actionPoints - 1;
    }

    //getters
    public double getMoney() {
        return money;
    }

    public double getBankMoney() {
        return bankMoney;
    }

    public double getBill() {
        return bill;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public double getSalary() {
        return salary;
    }

    //setters
    private void setBill() { //set the bill value
        Random rand = new Random();

        bill += rand.nextDouble(121);
    }

    private void setSalary() {
        Random rand = new Random();

        salary = rand.nextDouble(121);
    }

    public void resetActionPoints() {
        this.actionPoints = 3;
    }
}