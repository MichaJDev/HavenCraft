package SpackkVenture.Main;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import SpackkVenture.Config.ConfigHandler;
import SpackkVenture.Listeners.MobMoneyListener;
import net.milkbowl.vault.economy.Economy;

public class SpackkVenture extends JavaPlugin {

	public Economy econ = null;
	protected ConfigHandler cfg;
	protected int plugID = 6980;

	@Override
	public void onEnable() {
		cfg = new ConfigHandler(this);
		saveDefaultConfig();
		getLogger().info("Setting up Configuration Files");
		cfg.SetupConfig();
		getLogger().info("Setting up Vault hook");
		getLogger().info("Getting PVE Listeners");
		getListeners();
		getLogger().info("Setting up Metrics Hook");
		@SuppressWarnings("unused")
		Metrics met = new Metrics(this, plugID);
	}

	@SuppressWarnings("unused")
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

	private void getListeners() {
		getServer().getPluginManager().registerEvents(new MobMoneyListener(this), this);
	}
}
