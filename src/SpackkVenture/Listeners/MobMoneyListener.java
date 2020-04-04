package SpackkVenture.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import SpackkVenture.Listeners.Core.MoneyHandler;
import SpackkVenture.Main.SpackkVenture;

public class MobMoneyListener implements Listener {
	SpackkVenture main;
	MoneyHandler money;

	public MobMoneyListener(SpackkVenture main) {
		this.main = main;
		money = new MoneyHandler(main);
	}

	@EventHandler
	public void OnEntityDeath(EntityDeathEvent e) {
		if (e.getEntity().getKiller() == null)
			return;
		if (!(e.getEntity().getKiller() instanceof Player))
			return;
		if (!(e.getEntity() instanceof Player))
			return;
		double cur = money.GetDepositeAmount(e.getEntityType());
		DropMoneyItem(e.getEntity(), cur);
	}

	@EventHandler
	public void OnPlayerPickUp(EntityPickupItemEvent e) {
		Player p = (Player) e.getEntity();
		if (e.getEntity() instanceof Player) {
			if (e.getItem().getItemStack().getItemMeta().getDisplayName().contains("Money")) {
				ItemStack i = e.getItem().getItemStack();
				p.getInventory().remove(i);
				main.econ.depositPlayer(p,
						Double.parseDouble(i.getItemMeta().getDisplayName().replaceAll(" Money", "")));
				double cur = Double.parseDouble(i.getItemMeta().getDisplayName().replaceAll(" Money", ""));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', "&bAdded &e" + main.econ.currencyNameSingular()
								+ cur + " &bto your balance for killing" + e.getEntityType()));
			} else {
				return;
			}
		}
	}

	private void DropMoneyItem(Entity e, double amount) {
		ItemStack is = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(amount + " Money");
		is.setItemMeta(im);
		e.getWorld().dropItem(e.getLocation(), is);
	}
}
