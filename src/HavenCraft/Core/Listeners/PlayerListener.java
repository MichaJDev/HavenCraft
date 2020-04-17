package HavenCraft.Core.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import HavenCraft.Main.SpackkVenture;

public class PlayerListener implements Listener {

	SpackkVenture main;

	public PlayerListener(SpackkVenture main) {
		this.main = main;
	}

	@EventHandler
	public void OnHunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		e.getPlayer().setFoodLevel(20);
	}

}
