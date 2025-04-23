package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;   // 蛇对象
	private Food food;     // 食物对象
	private int score = 0;
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();  // 创建蛇
		food = new Food();    // 创建初始食物
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() {
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//System.out.println("Keypress: " + dir);
			if (dir != -1) {
				snake.changeDirection(dir);  // 将方向传给蛇
			}

			snake.move();  // 移动蛇

			if (snake.eatFood(food)) {
				food = new Food();
				score++;// 如果吃到食物，生成新的
			}

			updateDrawing();  // 重新绘制画面

			StdDraw.pause(100); // 控制游戏速度（越小越快）
		}

		// 游戏结束
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.5, 0.55, "Game Over!");
		StdDraw.text(0.5, 0.5, "Final Score: " + score); // ✅ 显示最终得分
		StdDraw.show();
			//Testing only: you will eventually need to do more work here
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
	
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		StdDraw.clear();        // 清空画布
		snake.draw();           // 画蛇
		food.draw();            // 画食物
		// ✅ 显示分数
	    StdDraw.setPenColor(StdDraw.BLACK);
	    StdDraw.textLeft(0.02, 0.98, "Score: " + score);
		StdDraw.show();
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
