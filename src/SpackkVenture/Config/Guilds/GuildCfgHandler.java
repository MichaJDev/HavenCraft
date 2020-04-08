package SpackkVenture.Config.Guilds;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import SpackkVenture.Main.SpackkVenture;

public class GuildCfgHandler {

	protected SpackkVenture main;

	public GuildCfgHandler(SpackkVenture main) {
		this.main = main;
	}

	public void Setup() {

	}

	private void CreateDir() {
		File file = new File(main.getDataFolder(), "/Guilds/");
		if (!file.exists()) {
			try {
				file.mkdirs();
			} catch (Exception e) {
				main.getLogger().severe(e.toString());
			}
		}
	}

	public void Create(Player p, String name) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', MsgHandler.getMessage("Guild.Creating")));
	}

	private File GetDir() {
		return new File(main.getDataFolder(), "/Guilds/");
	}

	private void CreateFile(String name) {
		File file = new File(GetDir(), name + "yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
		}
	}

}
