import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return category + ": " + amount;
    }
}

public class PersonalExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions: 1. Add Expense 2. View Expenses 3. Delete Expense 4. View Summary 5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1: // Add Expense
                    System.out.println("Enter category (e.g., Food, Transport): ");
                    String category = scanner.nextLine();
                    System.out.println("Enter amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(category, amount));
                    System.out.println("Expense added.");
                    break;

                case 2: // View Expenses
                    System.out.println("\nAll Expenses:");
                    for (int i = 0; i < expenses.size(); i++) {
                        System.out.println((i + 1) + ". " + expenses.get(i));
                    }
                    break;

                case 3: // Delete Expense
                    System.out.println("Enter expense number to delete:");
                    int expenseNum = scanner.nextInt();
                    if (expenseNum > 0 && expenseNum <= expenses.size()) {
                        expenses.remove(expenseNum - 1);
                        System.out.println("Expense deleted.");
                    } else {
                        System.out.println("Invalid expense number.");
                    }
                    break;

                case 4: // View Summary
                    System.out.println("Expense Summary:");
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.amount;
                    }
                    System.out.println("Total Expenses: " + total);
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
