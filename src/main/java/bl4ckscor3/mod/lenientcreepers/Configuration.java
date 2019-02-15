package bl4ckscor3.mod.lenientcreepers;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class Configuration
{
	public static final ForgeConfigSpec CONFIG_SPEC;
	private static final Configuration CONFIG;

	public final BooleanValue onlyWithMobGriefingGamerule;

	static
	{
		Pair<Configuration,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Configuration::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	Configuration(ForgeConfigSpec.Builder builder)
	{
		onlyWithMobGriefingGamerule = builder
				.comment("If this is set to false, items will not be destroyed regardless of what the gamerule mobGriefing is set to")
				.define("onlyWithMobGriefingGamerule", true);
	}

	public static boolean onlyWithMobGriefingGamerule()
	{
		return CONFIG.onlyWithMobGriefingGamerule.get();
	}
}
