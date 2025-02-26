import java.util.Scanner;

public class ATMInterface {

    private static int balance = 1000; 
    private static int pin = 1234; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Interface");

        // Authenticate user
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            System.out.println("Authentication successful!");
            showMenu();
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }

        scanner.close();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            Scanner sc=new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: RS" + balance);
    }

    private static void depositMoney() {
        System.out.print("Enter the amount to deposit: RS");
        Scanner sc=new Scanner(System.in);
        int amount = sc.nextInt();

        if (amount > 0) {
            balance += amount;
            System.out.println("RS" + amount + " has been deposited successfully.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: RS: ");
        Scanner sc=new Scanner(System.in);
        int amount = sc.nextInt();

        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("RS" + amount + " has been withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}