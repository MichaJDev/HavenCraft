package HavenCraft.Core.Data;

import HavenCraft.Core.Data.Econ.JobCfgHandler;
import HavenCraft.Core.Data.Guilds.GuildCfgHandler;
import HavenCraft.Core.Data.Parties.PartyCfgHandler;
import HavenCraft.Core.Utils.Messages.MsgHandler;
import HavenCraft.Main.SpackkVenture;

public class ConfigHandler {

	public static JobCfgHandler getJobs(SpackkVenture main) {
		return new JobCfgHandler(main);
	}

	public static GuildCfgHandler getGuilds(SpackkVenture main) {
		return new GuildCfgHandler(main);
	}

	public static MsgHandler getMessages(SpackkVenture main) {
		return new MsgHandler(main);
	}

	public static PartyCfgHandler getPaties(SpackkVenture main) {
		return new PartyCfgHandler(main);
	}
}
