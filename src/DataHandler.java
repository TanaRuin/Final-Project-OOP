import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    public static void exportTransactionDataToCSV(List<Transaction> transactions, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("ID,User ID,Type,Category,Amount,Date,Description");
            for (Transaction transaction : transactions) {
                writer.println(transaction.getId() + "," +
                        transaction.getUserId() + "," +
                        transaction.getType() + "," +
                        transaction.getCategory() + "," +
                        transaction.getAmount() + "," +
                        transaction.getDate() + "," +
                        transaction.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Transaction> importTransactionDataFromCSV(String filename) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip header line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0]);
                    int userId = Integer.parseInt(parts[1]);
                    String type = parts[2];
                    String category = parts[3];
                    double amount = Double.parseDouble(parts[4]);
                    String date = parts[5];
                    String description = parts[6];
                    Transaction transaction = new Transaction(id, userId, type, category, amount, date, description);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
