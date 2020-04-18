package HavenCraft.Core.Data.Guilds;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import HavenCraft.Core.Models.Guild;
import HavenCraft.Main.HavenCraft;

public class GuildDB {

	HavenCraft main;

	public GuildDB(HavenCraft main) {
		this.main = main;
	}

	protected void Setup() {
		CreatePrimaryDir();
		CreateSettings();
	}

	private void CreatePrimaryDir() {
		File file = new File(main.getDataFolder(), "/Guilds/");
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	private File GetPrimaryDir() {
		return new File(main.getDataFolder(), "/Guilds/");
	}

	private void CreateSettings() {
		File file = new File(GetPrimaryDir(), "settings.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
			FillSettings();
		}
	}

	private File GetSettings() {
		return new File(GetPrimaryDir(), "settings.yml");
	}

	private FileConfiguration GetSettingsCfg() {
		return YamlConfiguration.loadConfiguration(GetSettings());
	}

	private void FillSettings() {
		GetSettingsCfg().addDefault("Guild.Cost", 25000);
		GetSettingsCfg().addDefault("Guild.MaxMembers", 40);
		GetSettingsCfg().addDefault("Guild.AllowHome", true);
		GetSettingsCfg().options().copyDefaults(true);
		try {
			GetSettingsCfg().save(GetSettings());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			main.getLogger().severe(e.toString());
		}
	}

	protected void CreateNew(Guild g) {
		CreateNewGuildDir(g);
	}

	private void CreateNewGuildDir(Guild g) {
		File file = new File(GetPrimaryDir(), "/" + g.GetGUUID().toString() + "/");
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
