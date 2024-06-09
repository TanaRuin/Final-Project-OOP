import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for creating a window to add a transaction
public class AddTransactionWindow extends JFrame {
    private final User user;
    private static int transactionIdCounter = 1;  // Static counter to generate unique IDs

    // Constructor
    public AddTransactionWindow(User user) {
        this.user = user;

        // Set window properties
        setTitle("Add Transaction");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Components for user input
        JLabel typeLabel = new JLabel("Type:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Income", "Expense"});
        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        // Button to add transaction
        JButton addButton = new JButton("Add");

        // ActionListener for addButton
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = (String) typeComboBox.getSelectedItem();
                String category = categoryField.getText();
                double amount = Double.parseDouble(amountField.getText());
                String date = dateField.getText();
                String description = descriptionField.getText();

                // Create new transaction
                Transaction transaction = new Transaction(
                        transactionIdCounter++,  // Incrementing transaction ID counter
                        user.hashCode(),  // Using user's hash code as a user ID
                        type,
                        category,
                        amount,
                        date,
                        description
                );

                // Add transaction to user
                user.addTransaction(transaction);
                // Show confirmation message
                JOptionPane.showMessageDialog(null, "Transaction Added!");
                // Dispose the window
                dispose();
            }
        });

        // Add components to panel
        panel.add(typeLabel);
        panel.add(typeComboBox);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(descriptionLabel);
        panel.add(descriptionField);
        panel.add(new JLabel());
        panel.add(addButton);

        // Add panel to window
        add(panel, BorderLayout.CENTER);

        // Set window visibility
        setVisible(true);
    }
}
