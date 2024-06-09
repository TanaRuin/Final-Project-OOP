import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {

    // Method to set up the GUI components with a Mac-inspired look and feel
    private void setMacLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to create a rounded border for buttons
    private void setRoundButton(JButton button) {
        button.setBackground(new Color(0, 204, 153));
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        button.setFont(button.getFont().deriveFont(18f));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // Method to create and display the login form
    public void openSignInForm(JFrame frame, LoginWindow user) {
        setMacLookAndFeel();

        JPanel f = new JPanel(new BorderLayout());
        f.setBackground(Color.white);
        f.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200)); // Add padding

        // Sign In Panel
        JPanel signInPanel = new JPanel(new GridBagLayout());
        signInPanel.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel titleLabel = new JLabel("Sign In");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        signInPanel.add(titleLabel, gbc);

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("User Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        signInPanel.add(usernameLabel, gbc);
        JTextField usernameTextField = new JTextField();
        setRoundTextField(usernameTextField);
        gbc.gridx = 1;
        signInPanel.add(usernameTextField, gbc);

        // Password Label and TextField
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        signInPanel.add(passwordLabel, gbc);
        JPasswordField passwordField = new JPasswordField();
        setRoundTextField(passwordField);
        gbc.gridx = 1;
        signInPanel.add(passwordField, gbc);

        // Sign In Button
        JButton signInButton = new JButton("Sign In");
        setRoundButton(signInButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        signInPanel.add(signInButton, gbc);

        f.add(signInPanel, BorderLayout.CENTER);

        frame.setContentPane(f);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to create a rounded text field
    private void setRoundTextField(JTextField textField) {
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    // Method to create and display the main dashboard
    public void openMainDashboard(JFrame frame, User user) {
        setMacLookAndFeel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.white);

        // Title
        JLabel titleLabel = new JLabel("Personal Finance Manager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 20)); // GridLayout with equal vertical spacing
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200)); // Add padding

        // Add Transaction Button
        JButton addTransactionButton = new JButton("Add Transaction");
        setRoundButton(addTransactionButton);
        buttonPanel.add(addTransactionButton);

        // View Transactions Button
        JButton viewTransactionsButton = new JButton("View Transactions");
        setRoundButton(viewTransactionsButton);
        buttonPanel.add(viewTransactionsButton);

        // Save Data Button
        JButton saveDataButton = new JButton("Save Data");
        setRoundButton(saveDataButton);
        buttonPanel.add(saveDataButton);

        // Load Data Button
        JButton loadDataButton = new JButton("Load Data");
        setRoundButton(loadDataButton);
        buttonPanel.add(loadDataButton);

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        setRoundButton(logoutButton);
        buttonPanel.add(logoutButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
