package view;

import model.Turnstile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final int CLOSED = 0;
    private static final int OPEN = 1;
    private Icon[] icons;
    private JLabel imageLabel;
    private JComboBox<Integer> coin;
    private JButton insertCoin;
    private JButton use;
    private JLabel status;

    public MainFrame() {
        super("Turnstile Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setup();
        pack();
        setLocationRelativeTo(null); // centre on screen
    }

    public void setInsertCoinListener(ActionListener listener) {
        insertCoin.addActionListener(listener);
    }

    public void setUseListener(ActionListener listener) {
        use.addActionListener(listener);
    }

    public void updateDisplay(Turnstile.State state) {
        switch (state) {
            case LOCKED:
                setTurnstileIcon(MainFrame.CLOSED);
                break;
            case UNLOCKED:
                setTurnstileIcon(MainFrame.OPEN);
                break;
        }
    }

    private void setup() {
        status = new JLabel("ready...");
        add(status, BorderLayout.NORTH);

        setupTurnstileIcon();
        setupControls();
    }

    private void setupTurnstileIcon() {
        icons = new ImageIcon[2];

        icons[CLOSED] = new ImageIcon("reasources/turnstile_closed.png");
        icons[OPEN] = new ImageIcon("reasources/turnstile_open.png");

        imageLabel = new JLabel(icons[CLOSED]);
        add(imageLabel, BorderLayout.CENTER);
    }

    private void setupControls() {
        JPanel bottomPanel = new JPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        coin = new JComboBox<>(new Integer[]{1, 2, 5, 10});
        insertCoin = new JButton("Insert coin");
        use = new JButton("Use");

        bottomPanel.add(coin);
        bottomPanel.add(insertCoin);
        bottomPanel.add(use);
    }

    private void setTurnstileIcon(int selection) {
        imageLabel.setIcon(icons[selection]);
    }

    public void setStatus(String message) {
        status.setText(message);
    }

    public int getCoin() {
        if (coin.getSelectedIndex() == -1) {
            return 0;
        }
        return coin.getItemAt(coin.getSelectedIndex());
    }
}
