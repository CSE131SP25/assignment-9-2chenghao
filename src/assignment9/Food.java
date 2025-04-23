package assignment9;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		generateNew(); // 调用生成新位置的方法
	}

	/**
	 * 在屏幕内生成新的随机位置
	 */
	public void generateNew() {
		Random rand = new Random();

		// 保证食物不会贴到边缘
		x = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * rand.nextDouble();
		y = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * rand.nextDouble();
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(Color.RED);       // 食物是红色的
		StdDraw.filledCircle(x, y, FOOD_SIZE); // 画出实心圆
	}

	// Getter 方法（用于检测是否被蛇吃到）
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
}
