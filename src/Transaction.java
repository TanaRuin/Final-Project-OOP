import java.io.Serializable;

// Class representing a transaction
public class Transaction implements Serializable {
    private int id; // Unique identifier for the transaction
    private int userId; // User ID associated with the transaction
    private String type; // Type of transaction (e.g., Income, Expense)
    private String category; // Category of the transaction
    private double amount; // Amount of the transaction
    private String date; // Date of the transaction
    private String description; // Description of the transaction

    // Constructor
    public Transaction(int id, int userId, String type, String category, double amount, String date, String description) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // toString method for displaying transaction details
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
