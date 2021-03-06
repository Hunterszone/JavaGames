package menu_states;

import java.awt.Graphics;

import util.Constants;

public class SettingsState {
    public static boolean isOn;
	public void render(Graphics g) {
		g.drawImage(Constants.LOAD_ASSETS.volume, 1100, 32, null);
		g.drawImage(Constants.LOAD_ASSETS.header, 428, 32, 352, 49, null);
        g.drawImage(Constants.LOAD_ASSETS.headerBackground, 180, 0, 802, 105, null);
        g.drawImage(Constants.LOAD_ASSETS.back, 410, 135, 388, 89, null);
        g.drawImage(Constants.LOAD_ASSETS.settingsText, 200, 265, 400, 120, null);
        g.drawImage(Constants.LOAD_ASSETS.settingsText, 200, 365, 400, 120, null);
        g.drawImage(Constants.LOAD_ASSETS.settingsText2, 200, 480, 300, 90, null);
        g.drawImage(Constants.LOAD_ASSETS.manual, 790, 485, 100, 100, null);
	}
}
