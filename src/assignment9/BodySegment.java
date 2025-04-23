package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = ColorUtils.solidColor();  
		//See ColorUtils for some color options (or choose your own)
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(this.color);             // 设置画笔颜色
		StdDraw.filledCircle(this.x, this.y, size);
	}
	public void moveTo(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	// Getter 方法：获取当前坐标
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
