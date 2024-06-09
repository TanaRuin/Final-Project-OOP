import java.util.Date;

// Class representing a financial goal
public class FinancialGoal {
    private int id; // Unique identifier for the financial goal

    // Constructor with id parameter
    public FinancialGoal(int id) {
        this.id = id;
    }

    // Getter method for id
    public int getId() {
        return id;
    }

    // Properties of a financial goal
    private String name; // Name of the financial goal
    private double targetAmount; // Target amount to achieve
    private Date targetDate; // Target date to achieve the goal
    private double currentAmount; // Current amount achieved towards the goal
    private String status; // Status of the goal (e.g., Active, Completed, Failed)

    // Constructor to initialize a financial goal
    public FinancialGoal(String name, double targetAmount, Date targetDate) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
        this.currentAmount = 0; // Initialize currentAmount to 0
        this.status = "Active"; // Set default status to Active
    }

    // Getter methods for properties
    public double getTargetAmount() {
        return targetAmount;
    }

    // Getter method for current amount
    public double getCurrentAmount() {
        return currentAmount;
    }

    // Getter method for status
    public String getStatus() {
        return status;
    }
}

