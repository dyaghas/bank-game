import java.util.Random;
import java.util.Scanner;

public class BankAccount extends Bank implements BankInterface{

    private double money = 1200.00;
    private double bankMoney = 0;
    private double bill;
    private double salary;
    private int actionPoints = 3;
    private int day;
    private String name;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void createBankAccount(){
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

    @Override
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

        if(money >= 100) { // the player can be robbed if he has more than $100.00
            rand = new Random();
            if(rand.nextFloat(10) < money / 1000.0) {
                money = money * rand.nextFloat(1);
                System.out.println("Someone robbed you. money remaining with you: " + money);
            }
        }
    }

    protected void work() {
        setSalary();
        money = money + salary;
    }

    @Override
    public void useActionPoint() {
        actionPoints = actionPoints - 1;
    }

    //getters
    @Override
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