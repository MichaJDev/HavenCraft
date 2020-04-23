package HavenCraft.Core.Data.Guilds;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import HavenCraft.Core.Models.Guild;
import HavenCraft.Main.HavenCraft;

public class GuildDB {

	HavenCraft main;
	HashMap<Guild, Player> invites = new HashMap<Guild, Player>();

	public GuildDB(HavenCraft main) {
		this.main = main;
	}

	protected void Setup() {
		CreatePrimaryDir();
		CreateSettings();
	}

	private void CreatePrimaryDir() {
		File file = new File(main.getDataFolder(), "/Guilds/");
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	protected UUID GetGUUIDFromPlayer(Player p) {
		UUID GUUID = null;
		for (File file : GetPrimaryDir().listFiles()) {
			for (File player : file.listFiles()) {
				if (player.getName().contains(p.getUniqueId().toString())) {
					GUUID = UUID.fromString(player.getParent());
				}
			}
		}
		return GUUID;
	}

	protected Guild GetGuild(UUID GUUID) {
		Guild g = new Guild(GUUID);
		FileConfiguration gcfg = GetGuildCfg(g);
		Player Leader = main.getServer().getPlayer(UUID.fromString(gcfg.getString("Leader")));
		g.SetGuildLeader(Leader);
		g.SetGuildName(gcfg.getString("Name"));
		return g;
	}

	private File GetPrimaryDir() {
		return new File(main.getDataFolder(), "/Guilds/");
	}

	private void CreateSettings() {
		File file = new File(GetPrimaryDir(), "settings.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
			FillSettings();
		}
	}

	private File GetSettings() {
		return new File(GetPrimaryDir(), "settings.yml");
	}

	private FileConfiguration GetSettingsCfg() {
		return YamlConfiguration.loadConfiguration(GetSettings());
	}

	private void FillSettings() {
		GetSettingsCfg().addDefault("Guild.Cost", 25000);
		GetSettingsCfg().addDefault("Guild.MaxMembers", 40);
		GetSettingsCfg().addDefault("Guild.AllowHome", true);
		GetSettingsCfg().options().copyDefaults(true);
		try {
			GetSettingsCfg().save(GetSettings());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			main.getLogger().severe(e.toString());
		}
	}

	protected void CreateNew(Guild g) {
		CreateNewGuildDir(g);
		CreateNewGuildFile(g);
	}

	private void CreateNewGuildDir(Guild g) {
		File file = new File(GetPrimaryDir(), "/" + g.GetGUUID().toString() + "/");
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	private File GetGuildDir(Guild g) {
		return new File(GetPrimaryDir(), "/" + g.GetGUUID().toString() + "/");

	}

	private void CreateNewGuildFile(Guild g) {
		File file = new File(GetGuildDir(g), g.GetGuildLeader().getUniqueId().toString() + ".yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				main.getLogger().severe(e.toString());
			}
			FillNewGuildFile(g);
		}
	}

	private File GetGuildFile(Guild g) {
		return new File(GetGuildDir(g), g.GetGUUID().toString() + ".yml");
	}

	private FileConfiguration GetGuildCfg(Guild g) {
		return YamlConfiguration.loadConfiguration(GetGuildFile(g));
	}

	private void FillNewGuildFile(Guild g) {
		FileConfiguration cfg = GetGuildCfg(g);
		cfg.addDefault("Name", g.GetGuildName());
		cfg.addDefault("Leader", g.GetGuildLeader().getUniqueId());
		cfg.addDefault("GUUID", g.GetGUUID());
		cfg.options().copyDefaults(true);
		try {
			cfg.save(GetGuildFile(g));
		} catch (IOException e) {
			main.getLogger().severe(e.toString());
		}
	}

	public void AddGuildInvite(Player inviter, Player target) {
		Guild g = GetGuild(GetGUUIDFromPlayer(inviter));

	}

	public HashMap<Guild, Player> GetGuildInvites() {
		return this.invites;
	}

	public void AddGuildMember(Player inviter, Player target) {

	}
}
