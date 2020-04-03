package SpackkVenture.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import SpackkVenture.Listeners.Core.MoneyHandler;
import SpackkVenture.Main.SpackkVenture;

public class EntityDeathListener implements Listener {
	SpackkVenture main;
	MoneyHandler money;

	public EntityDeathListener(SpackkVenture main) {
		this.main = main;
		money = new MoneyHandler(main);
	}

	@EventHandler
	public void OnEntityDeath(EntityDeathEvent e) {
		if (e.getEntity().getKiller() == null)
			return;
		OfflinePlayer p = e.getEntity().getKiller();
		Player op = (Player) p;
		double cur = money.GetDepositeAmount(e.getEntityType());
		op.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bAdded &e" + main.econ.currencyNameSingular() + cur
				+ " &bto your balance for killing" + e.getEntityType()));
		main.econ.depositPlayer(p, cur);
	}
}
