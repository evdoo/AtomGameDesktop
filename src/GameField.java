import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

/**
 * Created by Olga on 03.12.2014.
 */
public class GameField extends Canvas {

    public ArrayList<Point> gamePointMap;

    public GameField() {
        this.gamePointMap = setPointOnField();
    }

    public ArrayList<Point> setPointOnField() {
        int x;
        int y;

        Random r = new Random();
        ArrayList<Point> mapPoint = new ArrayList<Point>();
        while (!(mapPoint.size() == 10)) {
            x = (r.nextInt()*9 + 1);
            y = (r.nextInt()*9 + 1);
            if (!(mapPoint.contains(new Point(x, y)))) {
                mapPoint.add(new Point(x, y));
            }
        }
        return mapPoint;
    }

    public void paint(Graphics g) {
        int interval = this.getWidth()/13;

        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);

        int xStart = 0;
        int yStart = 0;

        g.drawRect(xStart, yStart, this.getWidth(), this.getHeight());

        for (int i = 0; i < 10; i++) {
            g.drawLine(xStart, yStart, xStart + interval, yStart);
            xStart += interval;
        }

        for (int i = 0; i < 10; i++) {
            g.drawLine(xStart, yStart, xStart, yStart + interval);
            yStart += interval;
        }
    }
}
