import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("Alice", 1000.0);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance());
    }

    @Test
    public void testOverdrawThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500.0);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(300.0);
        account.withdraw(100.0);
        List<String> history = account.getTransactionHistory();
        assertTrue(history.contains("Deposited: 300.0"));
        assertTrue(history.contains("Withdrew: 100.0"));
    }

    @Test
    public void testInvalidDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
    }

    @Test
    public void testInvalidWithdrawalThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10.0);
        });
    }
}
