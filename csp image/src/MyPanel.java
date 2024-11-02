import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyPanel extends JPanel implements MouseListener {

    private final int width, height, pixelSize;
    private int colorIndex, x, y, r;
    private final Color[] colors;

    public MyPanel(int width, int height) {

        super();
        this.width = width;
        this.height = height;

        // can choose b/w different pixelSizes for more or less pixelation

//        pixelSize = 1; // smooth
//        pixelSize = 50; // medium
        pixelSize = 100; // terraria

        // same w/ circle size

//        r = 50; // tiny circle
//        r = 150; // average
        r = 300; // juicy circle

        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        colorIndex = -1;
        colors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, new Color(255, 182, 193), Color.YELLOW};
        addMouseListener(this);

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        if(colorIndex > -1 && colorIndex < colors.length) {
            Color currentColor = colors[colorIndex];
            for(int j = 0; j < pixelSize * width; j += pixelSize) {
                for(int k = 0; k < pixelSize * height; k += pixelSize) {
                    int a = (int) (255d - 255d/r * Point.distance(j, k, x, y));
                    if(a > 0) {
                        g2d.setPaint(new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), a));
                        g2d.fillRect(j, k, pixelSize, pixelSize);
                    }
                }
            }
        }
//        g2d.setPaint(Color.BLACK);
//        for(int i = 0; i <= width; i++) g2d.drawLine(i * pixelSize, 0, i * pixelSize, height * pixelSize);
//        for(int i = 0; i <= height; i++) g2d.drawLine(0, i * pixelSize, width * pixelSize, i * pixelSize);

    }

//    public void printHexValues() throws IOException {
//
//        PrintWriter out = new PrintWriter(new FileWriter("hexValues.txt"));
//        Point location = getLocationOnScreen();
//        System.out.println("Printing...");
//        for(int i = 0; i < height; i++) {
//            System.out.println((i / height * 100) + "%");
//            int pixelY = location.y + pixelSize / 2 + pixelSize * i;
//            for(int j = 0; j < width; j++){
//                try {
//                    int pixelX = location.x + pixelSize / 2 + pixelSize * j;
//                    Color pixelColor = new Robot().getPixelColor(pixelX, pixelY);
//                    String r = Integer.toHexString(pixelColor.getRed()), g = Integer.toHexString(pixelColor.getGreen()), b = Integer.toHexString(pixelColor.getBlue());
//                    out.print(((r.length() == 1) ? "0" : "") + r + ((g.length() == 1) ? "0" : "") + g + ((b.length() == 1) ? "0" : "") + b + " ");
//                } catch (AWTException e) {
//                    e.printStackTrace();
//                }
//            }
//            out.println();
//        }
//        out.close();
//        System.out.println("Done");
//
//    }

    @Override
    public void mouseClicked(MouseEvent e) {

//        if(colorIndex < colors.length - 1) {
            colorIndex++;
            colorIndex %= colors.length;
            x = e.getX() - (e.getX() % pixelSize);
            y = e.getY() - (e.getY() % pixelSize);
            repaint();
//        } else if(colorIndex == colors.length - 1) {
//            colorIndex++;
//            try {
//                printHexValues();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
