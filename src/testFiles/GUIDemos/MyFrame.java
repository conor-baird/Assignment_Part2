import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JMenuItem exit;
    private JMenuItem about;
    private Ball ball;

    MyFrame() {
        super("My Frame Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        menuBar.add(file);
        menuBar.add(help);

        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");

        file.add(exit);
        help.add(about);

        setJMenuBar(menuBar);
        pack();

        setPreferredSize(new Dimension(600,400));
        setBackground(Color.PINK);

        Timer timer = new Timer(1, this);
        timer.start();
    }

    void addExitActionListener(ActionListener listener) {
        exit.addActionListener(listener);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ball.draw(g);
    }

    void addAboutActionListener(ActionListener listener) {
        about.addActionListener(listener);
    }

    void setModel(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
