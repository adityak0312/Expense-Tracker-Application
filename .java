import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;
    String date;

    public Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: " + amount + ", Date: " + date;
    }
}

class ExpenseTracker {
    ArrayList<Expense> expenses = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add an expense
    public void addExpense() {
        System.out.print("Enter category: ");
        String category = sc.next();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.next();
        expenses.add(new Expense(category, amount, date));
        System.out.println("Expense added successfully!");
    }

    // Show all expenses
    public void showExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    // Show total expenses
    public void showTotalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total expenses: " + total);
    }

    // Menu to choose actions
    public void showMenu() {
        while (true) {
            System.out.println("\n1. Add Expense\n2. Show All Expenses\n3. Show Total Expenses\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    showExpenses();
                    break;
                case 3:
                    showTotalExpenses();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.showMenu();
    }
}
