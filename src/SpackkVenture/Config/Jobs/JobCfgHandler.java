package SpackkVenture.Config.Jobs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import SpackkVenture.Main.SpackkVenture;

public class JobCfgHandler {

	protected SpackkVenture main;

	public JobCfgHandler(SpackkVenture main) {
		this.main = main;
		Setup();
	}

	private void Setup() {
		if (!GetJobDir().exists()) {
			CreateJobsDir();
			CreateJobsYml();
		}

	}

	private void CreateJobsDir() {
		File JobDir = new File(main.getDataFolder(), "/Jobs/");
		try {
			JobDir.mkdirs();
		} catch (Exception e) {
			main.getLogger().severe(e.toString());
		}
	}

	private void CreateJobsYml() {
		File file;
		String[] jobs = { "Hunter.yml", "Fisher.yml" };
		for (String s : jobs) {
			file = new File(GetJobDir(), s);
			try {
				file.createNewFile();
				SetupHunterFile();
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
	private void SetupHunterFile() throws IOException {

		GetHunterDrops().addDefault("bat.min-money", 1.0);
		GetHunterDrops().addDefault("bat.max-money", 2.0);

		GetHunterDrops().addDefault("blaze.min-money", 7.0);
		GetHunterDrops().addDefault("blaze.max-money", 155.0);

		GetHunterDrops().addDefault("cave_spider.min-money", 6.0);
		GetHunterDrops().addDefault("cave_spider.max-money", 14.0);

		GetHunterDrops().addDefault("chicken.min-money", 1.0);
		GetHunterDrops().addDefault("chicken.max-money", 2.0);

		GetHunterDrops().addDefault("cod.min-money", 1.0);
		GetHunterDrops().addDefault("cod.max-money", 2.0);

		GetHunterDrops().addDefault("cow.min-money", 1.0);
		GetHunterDrops().addDefault("cow.max-money", 2.0);

		GetHunterDrops().addDefault("creeper.min-money", 5.0);
		GetHunterDrops().addDefault("creeper.max-money", 10.0);

		GetHunterDrops().addDefault("dolphin.min-money", 1.0);
		GetHunterDrops().addDefault("dolphin.max-money", 2.0);

		GetHunterDrops().addDefault("donkey.min-money", 1.0);
		GetHunterDrops().addDefault("donkey.max-money", 2.0);

		GetHunterDrops().addDefault("drowned.min-money", 4.5);
		GetHunterDrops().addDefault("drowned.max-money", 9.0);

		GetHunterDrops().addDefault("elder_guardian.min-money", 700.0);
		GetHunterDrops().addDefault("elder_guardian.max-money", 1400.0);

		GetHunterDrops().addDefault("ender_dragon.min-money", 500.0);
		GetHunterDrops().addDefault("ender_dragon.max-money", 1000.0);

		GetHunterDrops().addDefault("enderman.min-money", 7.0);
		GetHunterDrops().addDefault("enderman.max-money", 15.0);

		GetHunterDrops().addDefault("endermite.min-money", 3.0);
		GetHunterDrops().addDefault("endermite.max-money", 5.0);

		GetHunterDrops().addDefault("evoker.min-money", 7.0);
		GetHunterDrops().addDefault("evoker.max-money", 12.0);

		GetHunterDrops().addDefault("ghast.min-money", 10.0);
		GetHunterDrops().addDefault("ghast.max-money", 15.0);

		GetHunterDrops().addDefault("giant.min-money", 20.0);
		GetHunterDrops().addDefault("giant.max-money", 30.0);

		GetHunterDrops().addDefault("guardian.min-money", 7.0);
		GetHunterDrops().addDefault("guardian.max-money", 11.0);

		GetHunterDrops().addDefault("horse.min-money", 1.0);
		GetHunterDrops().addDefault("horse.max-money", 2.0);

		GetHunterDrops().addDefault("husk.min-money", 4.5);
		GetHunterDrops().addDefault("husk.max-money", 9.0);

		GetHunterDrops().addDefault("illusioner.min-money", 7.0);
		GetHunterDrops().addDefault("illusioner.max-money", 12.0);

		GetHunterDrops().addDefault("iron_golem.min-money", 6.0);
		GetHunterDrops().addDefault("iron_golem.max-money", 12.0);

		GetHunterDrops().addDefault("llama.min-money", 1.0);
		GetHunterDrops().addDefault("llama.max-money", 2.0);

		GetHunterDrops().addDefault("magma_cube.min-money", 6.0);
		GetHunterDrops().addDefault("magma_cube.max-money", 10.0);

		GetHunterDrops().addDefault("mule.min-money", 1.0);
		GetHunterDrops().addDefault("mule.max-money", 2.0);

		GetHunterDrops().addDefault("mushroom_cow.min-money", 1.0);
		GetHunterDrops().addDefault("mushroom_cow.max-money", 2.0);

		GetHunterDrops().addDefault("ocelot.min-money", 1.0);
		GetHunterDrops().addDefault("ocelot.max-money", 2.0);

		GetHunterDrops().addDefault("parrot.min-money", 1.0);
		GetHunterDrops().addDefault("parrot.max-money", 2.0);

		GetHunterDrops().addDefault("phantom.min-money", 10.0);
		GetHunterDrops().addDefault("phantom.max-money", 17.0);

		GetHunterDrops().addDefault("pig.min-money", 1.0);
		GetHunterDrops().addDefault("pig.max-money", 2.0);

		GetHunterDrops().addDefault("pig_zombie.min-money", 6.0);
		GetHunterDrops().addDefault("pig_zombie.max-money", 12.0);

		GetHunterDrops().addDefault("polar_bear.min-money", 5.0);
		GetHunterDrops().addDefault("polar_bear.max-money", 9.5);

		GetHunterDrops().addDefault("pufferfish.min-money", 1.0);
		GetHunterDrops().addDefault("pufferfish.max-money", 2.0);

		GetHunterDrops().addDefault("rabbit.min-money", 1.0);
		GetHunterDrops().addDefault("rabbit.max-money", 3.0);

		GetHunterDrops().addDefault("salmon.min-money", 1.0);
		GetHunterDrops().addDefault("salmon.max-money", 2.0);

		GetHunterDrops().addDefault("sheep.min-money", 1.0);
		GetHunterDrops().addDefault("sheep.max-money", 2.0);

		GetHunterDrops().addDefault("shulker.min-money", 5.0);
		GetHunterDrops().addDefault("shulker.max-money", 8.0);

		GetHunterDrops().addDefault("silverfish.min-money", 2.0);
		GetHunterDrops().addDefault("silverfish.max-money", 4.0);

		GetHunterDrops().addDefault("skeleton.min-money", 7.0);
		GetHunterDrops().addDefault("skeleton.max-money", 12.0);

		GetHunterDrops().addDefault("skeleton_horse.min-money", 4.0);
		GetHunterDrops().addDefault("skeleton_horse.max-money", 6.0);

		GetHunterDrops().addDefault("slime.min-money", 4.0);
		GetHunterDrops().addDefault("slime.max-money", 8.0);

		GetHunterDrops().addDefault("snowman.min-money", 1.0);
		GetHunterDrops().addDefault("snowman.max-money", 2.0);

		GetHunterDrops().addDefault("spider.min-money", 4.5);
		GetHunterDrops().addDefault("spider.max-money", 9.0);

		GetHunterDrops().addDefault("squid.min-money", 1.0);
		GetHunterDrops().addDefault("squid.max-money", 2.0);

		GetHunterDrops().addDefault("stray.min-money", 7.0);
		GetHunterDrops().addDefault("stray.max-money", 12.0);

		GetHunterDrops().addDefault("turtle.min-money", 1.0);
		GetHunterDrops().addDefault("turtle.max-money", 2.0);

		GetHunterDrops().addDefault("vex.min-money", 4.0);
		GetHunterDrops().addDefault("vex.max-money", 7.0);

		GetHunterDrops().addDefault("villager.min-money", 1.0);
		GetHunterDrops().addDefault("villager.max-money", 2.0);

		GetHunterDrops().addDefault("vindicator.min-money", 7.0);
		GetHunterDrops().addDefault("vindicator.max-money", 12.0);

		GetHunterDrops().addDefault("witch.min-money", 8.0);
		GetHunterDrops().addDefault("witch.max-money", 14.0);

		GetHunterDrops().addDefault("wither.min-money", 1000.0);
		GetHunterDrops().addDefault("wither.max-money", 5000.0);

		GetHunterDrops().addDefault("wither_skeleton.min-money", 19.0);
		GetHunterDrops().addDefault("wither_skeleton.max-money", 14.0);

		GetHunterDrops().addDefault("wolf.min-money", 1.0);
		GetHunterDrops().addDefault("wolf.max-money", 2.0);

		GetHunterDrops().addDefault("zombie.min-money", 4.5);
		GetHunterDrops().addDefault("zombie.max-money", 9.0);

		GetHunterDrops().addDefault("zombie_villager.min-money", 4.5);
		GetHunterDrops().addDefault("zombie_villager.max-money", 9.0);

		GetHunterDrops().addDefault("zombie_horse.min-money", 2.0);
		GetHunterDrops().addDefault("zombie_horse.max-money", 4.0);
		GetHunterDrops().options().copyDefaults(true);

		GetHunterDrops().save(GetHunterJobFile());

	}

}
