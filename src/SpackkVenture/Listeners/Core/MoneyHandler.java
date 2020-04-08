package SpackkVenture.Listeners.Core;

import org.bukkit.entity.EntityType;

import SpackkVenture.Config.ConfigHandler;
import SpackkVenture.Config.Jobs.JobCfgHandler;
import SpackkVenture.Main.SpackkVenture;

public class MoneyHandler {
	protected SpackkVenture main;
	protected JobCfgHandler cfg;

	public MoneyHandler(SpackkVenture main) {
		this.main = main;
		cfg = new ConfigHandler(main).getJobs();
	}

	public double GetDepositeAmount(EntityType type) {
		return (double) (Math.random() * ((cfg.GetHunterDrops().getInt(type.toString().toLowerCase() + ".max-money")
				- cfg.GetHunterDrops().getInt(type.toString().toLowerCase() + ".min-money")) + 1))
				+ cfg.GetHunterDrops().getInt(type.toString().toLowerCase() + ".max-money");

	}
}
