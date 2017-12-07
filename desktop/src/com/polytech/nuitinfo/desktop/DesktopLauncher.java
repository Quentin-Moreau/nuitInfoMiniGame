package com.polytech.nuitinfo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.polytech.nuitinfo.miniMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = miniMain.WIDTH;
		config.height = miniMain.HEIGHT;
		config.title = miniMain.TITLE;
		new LwjglApplication(new miniMain(), config);

	}
}
