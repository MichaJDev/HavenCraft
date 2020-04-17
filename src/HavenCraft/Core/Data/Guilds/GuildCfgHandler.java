package HavenCraft.Core.Data.Guilds;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import HavenCraft.Core.Data.ConfigHandler;
import HavenCraft.Core.Models.Guild;
import HavenCraft.Core.Models.Interfaces.IGuild;
import HavenCraft.Core.Utils.Messages.MsgHandler;
import HavenCraft.Main.SpackkVenture;

public class GuildCfgHandler {

	protected SpackkVenture main;
	protected MsgHandler msg;

	public GuildCfgHandler(SpackkVenture main) {
		this.main = main;
		msg = ConfigHandler.getMessages(main);
		Setup();
	}

	private void Setup() {
		if (!GetDir().exists()) {
			CreateDir();
		}
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

	public void CreateNewGuild(Player p, String guildName) {
		Guild g = new Guild(p, guildName);
	}

	public void AddMember(Player p) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg.getMessage("Guild.Creating")));
		Guild g = GuildHandler.getGuild(p);
		CreateMemberFile(g, p);

	}

	public void Invite(Player p, String name) {

	}

	private File GetDir() {
		return new File(main.getDataFolder(), "/Guilds/");
	}

	private void CreateGuildDir(Guild g) {
		File file = new File(GetDir(), g.GetGuilGUUID().toString() + GetDir().listFiles().length + ".yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
		}
	}

	private void CreateMemberFile(Guild g, Player p) {
		File file = new File(GetDirGuild(g.GetGuilGUUID()), p.getUniqueId().toString() + "yml");
		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
			FillPlayerFile(g);
		}
	}

	private File GetGuildFile(Guild g) {
		for (File file : GetDir().listFiles()) {
			for (File gFile : file.listFiles()) {
				if (gFile.getName().contains(g.GetGuilGUUID().toString())) {
					return gFile;
				}
			}
		}
		return null;
	}

	private void FillPlayerFile(Guild guild) {
		for (File file : GetDir().listFiles()) {
			if (file.getName().contains(guild.GetGuilGUUID().toString())) {
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.addDefault("GuildName", guild.GetGuildName());
			}
		}
	}

}
