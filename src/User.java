import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Class representing a User
public class User implements Serializable {
    private String username; // Username of the user
    private String password; // Password of the user
    private List<Transaction> transactions; // List of transactions associated with the user

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.transactions = new ArrayList<>(); // Initialize the list of transactions
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Getter method for transactions list
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Method to add a transaction to the user's list of transactions
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}

