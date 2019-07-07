package potogold;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public class Timer extends GameObject {

	private Font font;
	long startTime = System.currentTimeMillis();
	static long elapsedMillis;
	static String initialTime;

	public Timer(int x, int y, Font font) {
		super(x, y);
		this.font = font;
	}

	@Override
	public void draw(Graphics g) {
		g.setFont(font);
		initialTime = null;
		if (60 - (elapsedMillis / 1000) > 0 && Lives.lives != 0) {
			initialTime = String.format("%02d", 60 - (elapsedMillis / 1000));
			g.drawString(initialTime, x, y);
			return;
		}
		if ((60 - (elapsedMillis / 1000)) == 0) {
			initialTime = String.format("%02d", 00);
			g.drawString(initialTime, x, y);
			return;
		}
		if (Lives.lives == 0) {
			initialTime = String.format("%02d", 00);
			g.drawString(initialTime, x, y);
			return;
		}

	}

	public void decrementTime() {
		elapsedMillis = System.currentTimeMillis() - startTime;
	}

}