package testFiles.turnStile.model;

import model.Turnstile;
import view.MainFrame;

import javax.swing.*;

public class Controller {
    public static void main(String[] args) {
        // create the Apps main objects
        Turnstile turnstile = new Turnstile();
        MainFrame mainFrame = new MainFrame();

        // setup button handling - using lambda syntax
        mainFrame.setInsertCoinListener(e -> {
            int coin = mainFrame.getCoin();
            boolean successful = turnstile.insertCoin(coin);

            if (successful) {
                mainFrame.updateDisplay(turnstile.getState());
                mainFrame.setStatus(turnstile.getState().toString());
            } else {
                mainFrame.setStatus("insert coin failed: turnstile already unlocked...");
            }
        });

        mainFrame.setUseListener(e -> {
            boolean successful = turnstile.use();

            if (successful) {
                int change = turnstile.getChange();
                if (change > 0) {
                    JOptionPane.showMessageDialog(mainFrame, "Change: " + change);
                }
                mainFrame.updateDisplay(turnstile.getState());
                mainFrame.setStatus(turnstile.getState().toString());
            } else {
                mainFrame.setStatus("unable to use: turnstile not unlocked yet...");
            }
        });

        // make frame visible for user
        mainFrame.setVisible(true);
    }
}
