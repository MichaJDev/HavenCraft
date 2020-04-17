package HavenCraft.Core.Data;

import HavenCraft.Core.Data.Econ.JobCfgHandler;
import HavenCraft.Core.Data.Guilds.GuildDB;
import HavenCraft.Core.Data.Parties.PartyCfgHandler;
import HavenCraft.Core.Utils.Messages.MsgHandler;
import HavenCraft.Main.HavenCraft;

public class ConfigHandler {

	public static JobCfgHandler getJobs(HavenCraft main) {
		return new JobCfgHandler(main);
	}

	public static GuildDB getGuilds(HavenCraft main) {
		return new GuildDB(main);
	}

	public static MsgHandler getMessages(HavenCraft main) {
		return new MsgHandler(main);
	}

	public static PartyCfgHandler getPaties(HavenCraft main) {
		return new PartyCfgHandler(main);
	}
}
