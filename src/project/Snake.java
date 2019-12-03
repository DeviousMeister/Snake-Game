package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.security.Key;


public class Snake {
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	//not hitting itself, in boundaries, apple move to a place away from snake, can't move left to right

	public static void main(String[] args) {
		theSnake snake = new theSnake(1);
		Apple manzana = new Apple();
		StdDraw.setScale(0, 20);
		snake.drawSnake();
		StdDraw.enableDoubleBuffering();
		while(snake.oops() == true && snake.getLocation().getX()>0 && snake.getLocation().getX()<20 && snake.getLocation().getY()>0 && snake.getLocation().getY()<20){
			StdDraw.show(85);
			StdDraw.clear();
			if(StdDraw.isKeyPressed(KeyEvent.VK_UP)){
				if(snake.getDirection() != DOWN){
					snake.setDirection(UP);
				}
			}
			else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
				if(snake.getDirection() != LEFT){
					snake.setDirection(RIGHT);
				}
			}
			else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
				if(snake.getDirection() != UP){
					snake.setDirection(DOWN);
				}
			}
			else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
				if(snake.getDirection() != RIGHT){
					snake.setDirection(LEFT);
				}
			}
			manzana.drawApple();
			if(snake.ateApple(manzana)){
				snake.move(true);
			}
			else{
				snake.move(false);
			}
			snake.drawSnake();
			StdDraw.show(85);
		}
		System.out.println("You lost");
	}
}