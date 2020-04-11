package SpackkVenture.Config;

import SpackkVenture.Config.Guilds.GuildCfgHandler;
import SpackkVenture.Config.Jobs.JobCfgHandler;
import SpackkVenture.Config.Messages.MsgHandler;
import SpackkVenture.Config.Parties.PartyCfgHandler;
import SpackkVenture.Main.SpackkVenture;

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
