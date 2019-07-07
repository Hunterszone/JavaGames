package sokoban;

import java.awt.Image;
import java.awt.Toolkit;

public class Player extends Actor {

	Image sokoimage;
	public String img;

	public Player(int x, int y) {
		super(x, y);
		img = "images/sokoban.png";
		sokoimage = Toolkit.getDefaultToolkit().createImage(img);
		this.setImage(sokoimage);
	}

	public void move(int x, int y) {
		int nx = this.x() + x;
		int ny = this.y() + y;
		this.setX(nx);
		this.setY(ny);
	}
}
