import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.*;

/**
 * Created by Olga on 03.12.2014.
 */
public class Game extends Frame {
    private final int frameWidth = 1000;
    private final int frameHeight = 700;

    public Game(String title) {
        this.setTitle(title);
        this.setSize(frameWidth, frameHeight);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                dispose();
                System.exit(0);
            }
        });

        //Создание объекта field, добавление его во фрейм.
        GameField field = new GameField();
        field.setSize(frameWidth / 2, frameHeight / 2);
        field.setVisible(true);
        this.add(field);

        Graphics g = getGraphics();
        field.paint(g);

        int xRay = 0;
        int yRay = 0;

        rayReflection(field.gamePointMap, xRay, yRay);
    }

    public static void main (String[] args) {
        Game newGame = new Game("Atom Game");
    }

    public void rayReflection(ArrayList<Point> mapPoint, int startXRay, int startYRay) {

        int finishXRay;
        int finishYRay;
        int xMax = 10;
        int yMax = 10;
        boolean rayStatus;

        for (Point p : mapPoint) {
            if (p.getX() == startXRay) {
                rayStatus = false; //поглощен
                break;
            }
            if (p.getX() == startXRay + 1) {
                finishXRay = p.getX() - 1;
                finishYRay = startYRay;
                rayReflection(mapPoint, finishXRay, finishYRay);
            } else if (p.getX() == startXRay - 1) {
                finishXRay = p.getX() - 1;
                finishYRay = startYRay;
                rayReflection(mapPoint, finishXRay, finishYRay);
            } else {
                finishXRay = startXRay;
                finishYRay = yMax;
                rayStatus = true; //прошел
                break;
            }
        }

//        for (Point p : mapPoint) {
//            if (p.getY() == startYRay) {
//                rayStatus = false; //поглощен
//                int xMark = (int) (canvas.getHeight() / 13 * p.getY()) + 1;
//                paint.setColor = Color.RED;
//                canvas.draw
//                break;
//            }
//            if (p.getY() == startYRay + 1) {
//                finishXRay = startXRay;
//                finishYRay = p.getY() - 1;
//                rayReflection(mapPoint, finishXRay, finishYRay);
//            } else if (p.getY() == startYRay - 1) {
//                finishXRay = startXRay;
//                finishYRay = p.getY() - 1;
//                rayReflection(mapPoint, finishXRay, finishYRay);
//            } else {
//                finishXRay = xMax;
//                finishYRay = startYRay;
//                rayStatus = true; //прошел
//                break;
//            }
//            if (rayStatus == true) {
//                int xMark = (int) (canvas.getHeight() / 13 * p.getY()) + 1;
//
//            }
//        }
    }
}
