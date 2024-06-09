import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFinancialGoalDialog extends JDialog {
    private JTextField nameField;
    private JTextField targetAmountField;
    private JTextField targetDateField;
    private MainDashboard mainDashboard;

    public AddFinancialGoalDialog(MainDashboard mainDashboard) {
        this.mainDashboard = mainDashboard;

        // Set title and size of the dialog
        setTitle("Add Financial Goal");
        setSize(400, 200);
        setLocationRelativeTo(mainDashboard);
        setLayout(new GridLayout(4, 2, 10, 10));
        setModal(true);

        // Add labels and text fields for user input
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Target Amount:"));
        targetAmountField = new JTextField();
        add(targetAmountField);

        add(new JLabel("Target Date (YYYY-MM-DD):"));
        targetDateField = new JTextField();
        add(targetDateField);

        // Add button for adding financial goal
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            double targetAmount = Double.parseDouble(targetAmountField.getText());
            Date targetDate = parseDate(targetDateField.getText());
            FinancialGoal financialGoal = new FinancialGoal(name, targetAmount, targetDate);
            mainDashboard.addFinancialGoal(financialGoal);
            dispose();
        });
        add(addButton);

        // Add button for canceling
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        setVisible(true);
    }

    // Method to parse string to Date object
    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
