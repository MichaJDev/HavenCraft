package SpackkVenture.Config.Messages;

import SpackkVenture.Main.SpackkVenture;

public class MsgHandler {

	protected SpackkVenture main;

	public MsgHandler(SpackkVenture main) {
		this.main = main;
	}

	public String getMessage(String string) {
		return main.getConfig().getString(string);
	}
}
