package HavenCraft.Core.Data.Guilds;

import HavenCraft.Core.Models.Guild;
import HavenCraft.Main.HavenCraft;

public class GuildDB {

	HavenCraft main;

	public GuildDB(HavenCraft main) {
		this.main = main;
	}

	public Guild getGuildFromPlayer() {
		return new Guild();
	}

}
