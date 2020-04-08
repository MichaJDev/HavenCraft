package SpackkVenture.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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
