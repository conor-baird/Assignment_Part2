package model;

public class Turnstile {
    public enum State {
        LOCKED, UNLOCKING, UNLOCKED
    }

    private State state;
    private int price;
    private int tally;
    private int change;

    public Turnstile() {
        this.price = 10;
        state = State.LOCKED;
        tally = 0;
        change = 0;
    }

    public boolean setPrice(int price) {
        // price can only be set when the machine is locked
        boolean locked = state == State.LOCKED;
        if (locked) {
            this.price = price;
        }
        return locked;
    }

    public State getState() {
        return state;
    }

    public boolean use() {
        // machine can only be used if it's unlocked
        boolean unlocked = state == State.UNLOCKED;
        if (unlocked) {
            change = tally - price;
            state = State.LOCKED;
        }
        return unlocked;
    }

    public int getChange() {
        // the machine only offers change when it's locked
        if (state == State.LOCKED) {
            int amount = change;
            change = 0;
            tally = 0;
            return amount;
        }
        return 0;
    }

    public boolean insertCoin(int amount) {
        // coins can only be inserted when the machine is
        // locked or it's unlocking
        if (state != State.UNLOCKED) {
            operate(amount);
            return true;
        }
        return false;
    }

    private void operate(int coinAmount) {
        switch (state) {
            case LOCKED:
                if (coinAmount <= 0) break;
                tally += coinAmount;
                if (tally >= price) {
                    state = State.UNLOCKED;
                } else {
                    state = State.UNLOCKING;
                }
                break;

            case UNLOCKING:
                tally += coinAmount;
                if (tally >= price) {
                    state = State.UNLOCKED;
                }
                break;
            case UNLOCKED:
                break;
        }
    }
}
