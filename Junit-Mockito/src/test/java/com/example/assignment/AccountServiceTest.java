package com.example.assignment;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.assignment.Account;

public class AccountServiceTest {

    private AccountRepository repository;
    private NotificationService notification;
    private AccountService service;

    @BeforeEach
    public void setUp() {
        repository = mock(AccountRepository.class);
        notification = mock(NotificationService.class);
        service = new AccountService(repository, notification);
    }

    @Test
    public void testSuccessfulTransfer() {
        Account from = new Account("A1", 1000);
        Account to = new Account("A2", 500);

        when(repository.findById("A1")).thenReturn(from);
        when(repository.findById("A2")).thenReturn(to);

        service.transfer("A1", "A2", 300);

        assertEquals(700, from.getBalance());
        assertEquals(800, to.getBalance());

        verify(repository, times(1)).update(from);
        verify(repository, times(1)).update(to);
        verify(notification, times(1)).send("Transferred 300.0 from A1 to A2");
    }

    @Test
    public void testTransferFailsDueToInsufficientBalance() {
        Account from = new Account("A1", 100);
        Account to = new Account("A2", 500);

        when(repository.findById("A1")).thenReturn(from);
        when(repository.findById("A2")).thenReturn(to);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.transfer("A1", "A2", 300);
        });

        assertEquals("Insufficient balance", exception.getMessage());
        verify(repository, never()).update(any());
        verify(notification, never()).send(any());
    }

    @Test
    public void testTransferFailsIfAccountNotFound() {
        when(repository.findById("A1")).thenReturn(null);
        when(repository.findById("A2")).thenReturn(new Account("A2", 500));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.transfer("A1", "A2", 100);
        });

        assertEquals("Account not found", exception.getMessage());
        verify(repository, never()).update(any());
        verify(notification, never()).send(any());
    }
}
