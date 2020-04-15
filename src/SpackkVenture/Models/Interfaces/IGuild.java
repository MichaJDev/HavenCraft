package SpackkVenture.Models.Interfaces;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

public interface IGuild {

	public String GetGuildName();

	public UUID GetGuilGUUID();

	public Player GetGuildLeader();

	public List<Player> GetGuildModerators();

	public List<Player> GetGuildMembers();

	public void SetGuildName();

	public void SetGuildGUUID();

	public void SetGuildLeader();

	public void AddGuildModerator();

	public void DeleteModerator();

	public void DeleteGuildMember();
}
