package at.htl.robot.gui;

import at.htl.robot.model.Direction;
import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Tobias Hoefler
    Robot robot;

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
         //https://processing.org/tutorials/color/
        robot = new Robot();
        robot.setX(1);
        robot.setY(1);
    }

    int upperMargin = 50;
    int leftMargin = 50;
    int boxLength = 50;


    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        clear();
        background(209);
        strokeWeight(4);


        for (int i = 0; i < 11; i++) {
            line(leftMargin,
                    upperMargin + i * boxLength,
                    leftMargin + 10 * boxLength,
                    upperMargin + i * boxLength);

            line(leftMargin + i * boxLength,
                    upperMargin,
                    leftMargin + i * boxLength,
                    upperMargin + 10 * boxLength);
        }

        int boxCenterX = leftMargin - boxLength / 2 + robot.getX() * boxLength;
        int boxCenterY = leftMargin - boxLength / 2 + robot.getY() * boxLength;


        ellipse(boxCenterX,
                boxCenterY,
                (int) (boxLength * 0.7),
                (int) (boxLength * 0.7));

    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {

    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("Pressed: " + key + " Moving " + directionToString());

        if (key == 'f' || key == 'F') {

            if (robot.getY() < 10 && robot.getX() < 10)
            robot.stepForward();
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }

    }

    private String directionToString() {
        String directionString = "";

        switch (robot.getDirection()) {
            case NORTH:
                directionString = "North";
                break;
            case EAST:
                directionString = "East";
                break;
            case SOUTH:
                directionString = "South";
                break;
            case WEST:
                directionString = "West";
                break;
        }



        return directionString;
    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
