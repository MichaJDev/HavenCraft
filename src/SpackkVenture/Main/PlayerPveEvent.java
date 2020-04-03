package SpackkVenture.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerPveEvent implements Listener {

	SpackkVenture main;

	public PlayerPveEvent(SpackkVenture main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerPve(EntityDeathEvent e) {
		
	}
}
