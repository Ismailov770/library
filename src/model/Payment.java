package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Payment implements Serializable {
    private String userId;
    private double amount;
    private String type;
    private LocalDateTime timestamp;

    public Payment(String userId, double amount, String type) {
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
