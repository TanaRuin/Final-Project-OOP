import java.util.List;

public class ExpenseAnalyzer {

    public static double calculateTotalExpenses(List<Transaction> transactions) {
        double total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    public static double calculateAverageMonthlyExpenses(List<Transaction> transactions) {
        // Calculate total expenses
        double total = calculateTotalExpenses(transactions);

        // Calculate average monthly expenses
        return total / 12; // Assuming the transactions cover one year
    }

    public static double calculateExpensesByCategory(List<Transaction> transactions, String category) {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equalsIgnoreCase(category)) {
                total += transaction.getAmount();
            }
        }
        return total;
    }
}
