import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Class to display transactions in a window
public class ViewTransactionsWindow extends JFrame {
    private final User user; // User associated with the transactions

    // Constructor
    public ViewTransactionsWindow(User user) {
        // Set the Look and Feel to Macintosh-inspired
        try {
            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.user = user;

        // Set window properties
        setTitle("View Transactions");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Define column names for the table
        String[] columnNames = {"ID", "Type", "Category", "Amount", "Date", "Description"};
        List<Transaction> transactions = user.getTransactions();
        Object[][] data = new Object[transactions.size()][6];

        // Populate data array with transaction information
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            data[i][0] = transaction.getId();
            data[i][1] = transaction.getType();
            data[i][2] = transaction.getCategory();
            data[i][3] = transaction.getAmount();
            data[i][4] = transaction.getDate();
            data[i][5] = transaction.getDescription();
        }

        // Create table model with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true); // Ensure table fills the viewport
        JScrollPane scrollPane = new JScrollPane(table);

        // Add table with scroll pane to the window
        add(scrollPane, BorderLayout.CENTER);

        // Set window visibility
        setVisible(true);
    }
}
