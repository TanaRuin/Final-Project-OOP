import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainDashboard extends JFrame {
    private final User user;
    private List<FinancialGoal> financialGoals;{
        this.financialGoals = new ArrayList<>();

    }

    public MainDashboard(User user) {
        try {
            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.user = user;
        this.financialGoals = new ArrayList<>();

        setTitle("Personal Finance Manager");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addTransactionButton = new JButton("Add Transaction");
        JButton viewTransactionsButton = new JButton("View Transactions");
        JButton addFinancialGoalButton = new JButton("Add Financial Goal");
        JButton exportDataButton = new JButton("Export Data"); // Button to export data
        JButton importDataButton = new JButton("Import Data"); // Button to import data
        JButton analyzeExpensesButton = new JButton("Analyze Expenses"); // Button to analyze expenses
        JButton logoutButton = new JButton("Logout");
        JButton saveButton = new JButton("Save Data");
        JButton loadButton = new JButton("Clear Data");

        addTransactionButton.addActionListener(e -> new AddTransactionWindow(user).setVisible(true));
        viewTransactionsButton.addActionListener(e -> new ViewTransactionsWindow(user).setVisible(true));
        addFinancialGoalButton.addActionListener(e -> new AddFinancialGoalDialog(this).setVisible(true));
        exportDataButton.addActionListener(e -> exportData());
        importDataButton.addActionListener(e -> importData());
        analyzeExpensesButton.addActionListener(e -> analyzeExpenses());
        logoutButton.addActionListener(e -> logout());
        saveButton.addActionListener(e -> saveData());
        loadButton.addActionListener(e -> loadData());

        panel.add(addTransactionButton);
        panel.add(viewTransactionsButton);
        panel.add(addFinancialGoalButton);
        panel.add(exportDataButton);
        panel.add(importDataButton);
        panel.add(analyzeExpensesButton);
        panel.add(saveButton);
        panel.add(loadButton);
        panel.add(logoutButton);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void exportData() {
        String filename = "transactions.csv";
        DataHandler.exportTransactionDataToCSV(user.getTransactions(), filename);
    }

    private void importData() {
        String filename = "transactions.csv";
        List<Transaction> importedTransactions = DataHandler.importTransactionDataFromCSV(filename);
        user.getTransactions().addAll(importedTransactions);
    }

    private void analyzeExpenses() {
        double totalExpenses = ExpenseAnalyzer.calculateTotalExpenses(user.getTransactions());
        double averageMonthlyExpenses = ExpenseAnalyzer.calculateAverageMonthlyExpenses(user.getTransactions());
        double groceriesExpenses = ExpenseAnalyzer.calculateExpensesByCategory(user.getTransactions(), "Groceries");

        JOptionPane.showMessageDialog(null, "Total Expenses: $" + totalExpenses +
                "\nAverage Monthly Expenses: $" + averageMonthlyExpenses +
                "\nGroceries Expenses: $" + groceriesExpenses);
    }


    private void logout() {
        dispose();
        new LoginWindow().setVisible(true);
    }

    private void saveData() {
        SerializationUtil.saveData(user, "user_data.ser");
        JOptionPane.showMessageDialog(null, "Data Saved!");
    }

    private void loadData() {
        User loadedUser = (User) SerializationUtil.loadData("user_data.ser");
        if (loadedUser != null) {
            user.getTransactions().clear();
            user.getTransactions().addAll(loadedUser.getTransactions());
            JOptionPane.showMessageDialog(null, "Data Loaded!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Load Data.");
        }
    }

    // In the MainDashboard class

    public void addFinancialGoal(FinancialGoal financialGoal) {
        financialGoals.add(financialGoal);
        JOptionPane.showMessageDialog(null, "Financial Goal Added!");
    }

}
