package SpackkVenture.Main;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import SpackkVenture.Config.ConfigHandler;
import SpackkVenture.Config.Messages.MsgHandler;
import SpackkVenture.Config.Guilds.GuildCfgHandler;
import SpackkVenture.Config.Jobs.JobCfgHandler;
import SpackkVenture.Listeners.MobMoneyListener;
import net.milkbowl.vault.economy.Economy;

public class SpackkVenture extends JavaPlugin {

	public Economy econ = null;
	protected ConfigHandler cfg;
	protected int plugID = 6980;
	protected MsgHandler msg;
	protected JobCfgHandler jobs;
	protected GuildCfgHandler guilds;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getLogger().info("Setting up Configuration Files");
		msg = ConfigHandler.getMessages(this);
		jobs = ConfigHandler.getJobs(this);
		guilds = ConfigHandler.getGuilds(this);
		getLogger().info("Setting up Vault hook");
		setupEconomy();
		getLogger().info("Getting PVE Listeners");
		getServer().getPluginManager().registerEvents(new MobMoneyListener(this), this);
		getLogger().info("Setting up Metrics Hook");
		@SuppressWarnings("unused")
		Metrics met = new Metrics(this, plugID);
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

}
