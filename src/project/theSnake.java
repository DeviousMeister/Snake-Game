package project;

//starting position, update(direction)

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.LinkedList;

//have to add when it hits itself and when it moves the opposite way

public class theSnake {
    private int direction;
    private LinkedList<Points> location;
    private Points place;
    public final int UP = 0;
    public final int RIGHT = 1;
    public final int DOWN = 2;
    public final int LEFT = 3;
    public final int STILL = 4;

    public theSnake(double direction) {
        this.location = new LinkedList<>();
        location.add(new Points(3, 10));
        location.add(new Points(4, 10));
        this.direction = STILL;
    }

    public void drawSnake(){
        for(Points t: location){
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.filledSquare(t.getX(), t.getY(), 0.5);
        }
    }

    public Points getLocation(){
        return location.getFirst();
    }

    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void move(boolean ateApple){
        Points head = location.getFirst();
        if(this.direction == UP){
            Points newHead = new Points(head.getX(), head.getY()+1);
            location.addFirst(newHead);
        }
        else if(this.direction == RIGHT){
            Points newHead = new Points(head.getX()+1, head.getY());
            location.addFirst(newHead);
        }
        else if(this.direction == DOWN){
            Points newHead = new Points(head.getX(), head.getY()-1);
            location.addFirst(newHead);
        }
        else if(this.direction == LEFT){
            Points newHead = new Points(head.getX()-1, head.getY());
            location.addFirst(newHead);
        }
        if(!ateApple && this.direction != STILL){
            location.removeLast();
        }
    }

    public boolean ateApple(Apple food){
        double distance = Math.sqrt(Math.pow(location.getFirst().getX()-food.getLocation().getX(), 2)+Math.pow(location.getFirst().getY()-food.getLocation().getY(), 2));
        if(distance<=0.5){
            double xPlace = Math.random()*20;
            double yPlace = Math.random()*20;
            while(xPlace<1 && xPlace>19 && yPlace<1 && yPlace>19){
                xPlace = Math.random()*20;
                yPlace = Math.random()*20;
            }
            food.getLocation().setX(xPlace);
            food.getLocation().setY(yPlace);
            return true;
        }
        return false;
    }

    public boolean oops(){
        for(Points t: location){
            if (t.equals(location.getFirst())==false){
                if( location.getFirst().getX()== t.getX() && location.getFirst().getY()==t.getY()){
                    return false;
                }
            }
        }
        return true;
    }

}
