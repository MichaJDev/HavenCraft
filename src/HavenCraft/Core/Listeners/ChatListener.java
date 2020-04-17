package HavenCraft.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import HavenCraft.Main.SpackkVenture;

public class ChatListener implements Listener {

	SpackkVenture main;

	private String normalChatFormat;

	public ChatListener(SpackkVenture main) {
		this.main = main;
	}

	@EventHandler
	public void OnChat(AsyncPlayerChatEvent e) {
		// String formattedMsg = Format(e.getPlayer().getDisplayName(), e.getMessage(),
		// )
		if (e.getMessage().startsWith("#", 0)) {
			//send stuff to party chat
		}else if(e.getMessage().startsWith("%")) {
			//send stuff to guild chat
		}
	}

	private String Format(String name, String msg, String format) {
		String formattedMSG = format;

		formattedMSG = formattedMSG.replace("<name>", name);
		formattedMSG = formattedMSG.replace("<message>", msg);
		formattedMSG = ChatColor.translateAlternateColorCodes('&', formattedMSG);

		return formattedMSG;
	}

	private void SendMessage(String message, Location location, int radius) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (radius <= 0) {
				player.sendMessage(message);
			} else {
				double distance = location.distanceSquared(player.getLocation());
				if (distance <= Math.pow(radius, 2)) {
					player.sendMessage(message);
				}
			}
		}
	}

}
