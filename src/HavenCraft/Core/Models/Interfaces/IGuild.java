package HavenCraft.Core.Models.Interfaces;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

public interface IGuild {

	public String GetGuildName();

	public UUID GetGUUID();

	public Player GetGuildLeader();

	public List<Player> GetGuildModerators();

	public List<Player> GetGuildMembers();

	public void SetGuildName(String name);

	public void SetGUUID(UUID id);

	public void SetGuildLeader(Player p);

}
