package SpackkVenture.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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
	private ItemStack droppedItem;
	private double cur;

	public MobMoneyListener(SpackkVenture main) {
		this.main = main;
		money = new MoneyHandler(main);
	}

	@EventHandler
	public void OnEntityDeath(EntityDeathEvent e) {
		e.getEntity().getKiller();

		if (e.getEntity().getKiller() == null) {
			return;
		}
		cur = Math.round(money.GetDepositeAmount(e.getEntityType()) * 100.0) / 100.0;
		droppedItem = DropMoneyItem(e.getEntity(), cur);
		e.getDrops().add(droppedItem);

	}

	@EventHandler(priority = EventPriority.HIGH)
	public void OnMoneyPickUp(EntityPickupItemEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getItem().getItemStack().getType() == Material.GOLD_NUGGET) {
				e.setCancelled(true);
				e.getItem().remove();
				// e.getItem().setItemStack(new ItemStack(Material.AIR));
				main.econ.depositPlayer(p, cur);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&bThere has been &e" + cur + " &badded to your balance."));
			}
		}
	}

	private ItemStack DropMoneyItem(Entity e, double amount) {
		ItemStack is = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("Money");
		is.setItemMeta(im);
		return is;
	}
}
