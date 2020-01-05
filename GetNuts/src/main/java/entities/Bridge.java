package entities;

import java.awt.Image;
import java.awt.Toolkit;

import game_engine.Actor;

public class Bridge extends Actor {

	private Image image;
	public String img;

	public Bridge(int x, int y) {
		super(x, y);
		img = "images/bridge.png";
		image = Toolkit.getDefaultToolkit().createImage(img);
		this.setImage(image);
		return;
	}
}