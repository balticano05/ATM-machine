package entity.cards;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Card {
    private String cardNumber;
    private String pin;
    private double balance;
    private boolean blocked;
    private byte attempts;
    private LocalDateTime unlockDate;

    private Card(String cardNumber, String pin, double balance, boolean blocked, byte attempts, LocalDateTime unlockDate) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.blocked = blocked;
        this.attempts = attempts;
        this.unlockDate = unlockDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public byte getAttempts() {
        return attempts;
    }

    public void setAttempts(byte attempts) {
        this.attempts = attempts;
    }

    public LocalDateTime getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(LocalDateTime unlockDate) {
        this.unlockDate = unlockDate;
    }

    public void decAttempts(){
        if(this.attempts > 0){
            this.attempts--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    public static Card buildCard(String cardNumber, String pin, double balance, LocalDateTime unlockDate,boolean blocked, byte attempts) {
        return new Card(cardNumber, pin, balance, blocked, attempts, unlockDate);
    }

    public String getUnlockDateString() {
        if (this.unlockDate == null) {
            return "null";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return this.unlockDate.format(formatter);
    }

    @Override
    public String toString() {
            return cardNumber+" "+pin+" "+balance+" "+ getUnlockDateString()+" " +blocked+" "+attempts;
    }
}
