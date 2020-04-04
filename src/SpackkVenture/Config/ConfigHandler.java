package SpackkVenture.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import SpackkVenture.Main.SpackkVenture;

public class ConfigHandler {
	protected SpackkVenture main;

	public ConfigHandler(SpackkVenture main) {
		this.main = main;
	}

	public void SetupConfig() {
		if (!GetJobDir().exists()) {
			CreateJobDir();
			CreateJobYml();
		}
	}

	private void CreateJobDir() {
		File JobDir = new File(main.getDataFolder(), "/Jobs/");
		try {
			JobDir.mkdirs();
		} catch (Exception e) {
			main.getLogger().severe(e.toString());
		}
	}

	private void CreateJobYml() {
		File file;
		String[] jobs = { "Hunter.yml", "Explorer.yml", "Crafter.yml" };
		for (String s : jobs) {
			file = new File(GetJobDir(), s);
			try {
				file.createNewFile();
			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
		}
	}

	private File GetJobDir() {
		return new File(main.getDataFolder(), "/Jobs/");
	}

	private File GetHunterJobFile() {
		return new File(GetJobDir(), "Hunter.yml");
	}

	private File GetExplorerFile() {
		return new File(GetJobDir(), "Explorer.yml");
	}

	private File GetCrafterFile() {
		return new File(GetJobDir(), "Crafter.yml");
	}

	public FileConfiguration GetHunterDrops() {
		return YamlConfiguration.loadConfiguration(GetHunterJobFile());
	}

	public FileConfiguration GetExplorerDrops() {
		return YamlConfiguration.loadConfiguration(GetExplorerFile());
	}

	public FileConfiguration GetCrafterDrops() {
		return YamlConfiguration.loadConfiguration(GetCrafterFile());
	}
	@SuppressWarnings("unused")
	private void SetupHunterFile() {
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("blaze.min-money", 1.0);
		GetHunterDrops().addDefault("blaze.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("cave_spider.min-money", 1.0);
		GetHunterDrops().addDefault("cave_spider.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("chicken.min-money", 1.0);
		GetHunterDrops().addDefault("chicken.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("cod.min-money", 1.0);
		GetHunterDrops().addDefault("cod.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("cow.min-money", 1.0);
		GetHunterDrops().addDefault("cow.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
		//Bat
		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 1.0);
	}

}
