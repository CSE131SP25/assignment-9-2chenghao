package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments = new LinkedList<>();
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		
		BodySegment head = new BodySegment(0.5, 0.5, SEGMENT_SIZE);
		segments.add(head);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		if (deltaX == 0 && deltaY == 0) return;

		// 1. 从尾巴往前，依次复制前一节的位置
		for (int i = segments.size() - 1; i > 0; i--) {
			BodySegment prev = segments.get(i - 1);
			segments.get(i).moveTo(prev.getX(), prev.getY());
		}

		// 2. 移动头部
		BodySegment head = segments.get(0);
		double newX = head.getX() + deltaX;
		double newY = head.getY() + deltaY;
		head.moveTo(newX, newY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for (BodySegment seg : segments) {
			seg.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.get(0);
		double dist = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));

		if (dist <= SEGMENT_SIZE + Food.FOOD_SIZE) {
			// 加一节到尾巴（用尾巴当前坐标）
			BodySegment tail = segments.get(segments.size() - 1);
			BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
			segments.add(newSegment);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.get(0);
		double x = head.getX();
		double y = head.getY();
		return x >= 0 && x <= 1 && y >= 0 && y <= 1;
	}
}
