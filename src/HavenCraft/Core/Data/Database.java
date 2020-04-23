package HavenCraft.Core.Data;

import HavenCraft.Core.Data.Econ.EconDB;
import HavenCraft.Core.Data.Guilds.GuildDB;
import HavenCraft.Core.Data.Parties.PartyCfgHandler;
import HavenCraft.Core.Utils.Messages.MsgHandler;
import HavenCraft.Main.HavenCraft;

public class Database {

	public static EconDB GetEconDB(HavenCraft main) {
		return new EconDB(main);
	}

	public static GuildDB GetGuildDB(HavenCraft main) {
		return new GuildDB(main);
	}

	public static MsgHandler GetMessages(HavenCraft main) {
		return new MsgHandler(main);
	}

	public static PartyCfgHandler GetPartyDB(HavenCraft main) {
		return new PartyCfgHandler(main);
	}
}
