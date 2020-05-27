package menu_states;

import menu_engine.Constants;

import java.awt.*;

public class MenuState {

	public static boolean isOn = true;

	public void render(Graphics g) {
		Font titleFont = new Font("arial", Font.BOLD, 50);
		g.setFont(titleFont);
		g.setColor(Color.LIGHT_GRAY);

		Font buttonFont = new Font("arial", Font.BOLD, 30);
		g.setFont(buttonFont);

		g.drawImage(Constants.LOAD_ASSETS.playGame, 410, 135, 388, 89, null);
		g.drawImage(Constants.LOAD_ASSETS.loadGame, 410, 235, 388, 89, null);
		g.drawImage(Constants.LOAD_ASSETS.settingsButton, 410, 335, 388, 89, null);
		g.drawImage(Constants.LOAD_ASSETS.quitGame, 410, 435, 388, 89, null);
	}
}
