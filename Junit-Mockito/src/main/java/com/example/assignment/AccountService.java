package com.example.assignment;

public class AccountService {


    private AccountRepository repository;
    private NotificationService notification;

    public AccountService(AccountRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void transfer(String fromId, String toId, double amount) {
        Account from = repository.findById(fromId);
        Account to = repository.findById(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Account not found");
        }

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        from.withdraw(amount);
        to.deposit(amount);

        repository.update(from);
        repository.update(to);

        notification.send("Transferred " + amount + " from " + fromId + " to " + toId);
    }
}
