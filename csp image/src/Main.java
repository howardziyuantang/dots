import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel(2000, 2000);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);

    }

}
