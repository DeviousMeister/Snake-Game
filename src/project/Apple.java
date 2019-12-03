package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.LinkedList;

public class Apple {
    private Points location;
    //relocation away from snake;

    public Apple() {
        location = new Points(17, 10);
    }

    public Points getLocation() {
        return location;
    }

    public void drawApple(){
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledSquare(location.getX(), location.getY(), 0.5);
    }
}
