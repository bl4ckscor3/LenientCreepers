package bl4ckscor3.mod.lenientcreepers;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class Configuration {
	public static final ModConfigSpec CONFIG_SPEC;
	private static final Configuration CONFIG;
	public final BooleanValue onlyWithMobGriefingGamerule;

	static {
		Pair<Configuration, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Configuration::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	Configuration(ModConfigSpec.Builder builder) {
		//@formatter:off
		onlyWithMobGriefingGamerule = builder
				.comment("If this is set to false, items will not be destroyed regardless of what the gamerule mobGriefing is set to")
				.define("onlyWithMobGriefingGamerule", true);
		//@formatter:on
	}

	public static boolean onlyWithMobGriefingGamerule() {
		return CONFIG.onlyWithMobGriefingGamerule.get();
	}
}
