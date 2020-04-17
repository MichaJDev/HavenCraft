package HavenCraft.Core.Listeners.Money;

import org.bukkit.entity.EntityType;

import HavenCraft.Core.Data.ConfigHandler;
import HavenCraft.Core.Data.Econ.JobCfgHandler;
import HavenCraft.Main.HavenCraft;

public class MoneyHandler {
	protected HavenCraft main;
	protected JobCfgHandler cfg;

	public MoneyHandler(HavenCraft main) {
		this.main = main;
		cfg = ConfigHandler.getJobs(main);
	}

	public double GetDepositeAmount(EntityType type) {
		return (double) (Math.random() * ((cfg.GetHunterDrops().getInt(type.toString().toLowerCase() + ".max-money")
				- cfg.GetHunterDrops().getInt(type.toString().toLowerCase() + ".min-money")) + 1))
				+ cfg.GetHunterDrops().getInt(type.toString().toLowerCase() + ".max-money");

	}
	public double GetFishAmount(EntityType type) {
		return 0.0;
	}
}