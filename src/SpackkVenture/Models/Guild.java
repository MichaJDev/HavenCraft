package SpackkVenture.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import SpackkVenture.Models.Interfaces.IGuild;

public class Guild implements IGuild {

	String guildName = "";

	UUID guildGUUID = null;

	Player guildLeader = null;

	List<Player> guildModerators = new ArrayList<Player>();

	List<Player> guildMembers = new ArrayList<Player>();

	public Guild(Player p, String name) {
		guildName = name;
		guildLeader = p;
		guildGUUID = UUID.randomUUID();
	}

	@Override
	public String GetGuildName() {
		return guildName;
	}

	@Override
	public UUID GetGuilGUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player GetGuildLeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> GetGuildModerators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> GetGuildMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SetGuildName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetGuildGUUID() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetGuildLeader() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddGuildModerator() {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteModerator() {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteGuildMember() {
		// TODO Auto-generated method stub

	}

}
