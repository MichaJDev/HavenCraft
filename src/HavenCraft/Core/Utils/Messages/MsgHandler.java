package HavenCraft.Core.Utils.Messages;

import HavenCraft.Main.HavenCraft;

public class MsgHandler {

	protected HavenCraft main;

	public MsgHandler(HavenCraft main) {
		this.main = main;
	}

	public String getMessage(String string) {
		return main.getConfig().getString(string);
	}
}
