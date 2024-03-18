import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MyPanel panel = new MyPanel();
        add(panel);
    }
}