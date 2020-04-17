package HavenCraft.Main;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import HavenCraft.Core.Data.ConfigHandler;
import HavenCraft.Core.Data.Econ.JobCfgHandler;
import HavenCraft.Core.Data.Guilds.GuildDB;
import HavenCraft.Core.Listeners.MobMoneyListener;
import HavenCraft.Core.Utils.Messages.MsgHandler;
import net.milkbowl.vault.economy.Economy;

public class HavenCraft extends JavaPlugin {

	public Economy econ = null;
	protected ConfigHandler cfg;
	protected int plugID = 6980;
	protected MsgHandler msg;
	protected JobCfgHandler jobs;
	protected GuildDB guilds;

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
