package SpackkVenture.Config;

import SpackkVenture.Config.Guilds.GuildCfgHandler;
import SpackkVenture.Config.Jobs.JobCfgHandler;
import SpackkVenture.Main.SpackkVenture;

public class ConfigHandler {
	protected SpackkVenture main;

	public ConfigHandler(SpackkVenture main) {
		this.main = main;
	}

	public JobCfgHandler getJobs() {
		return new JobCfgHandler(main);
	}

	public GuildCfgHandler getGuilds() {
		return new GuildCfgHandler(main);
	}

	public void Setup() {
		getJobs().Setup();
	}

}
