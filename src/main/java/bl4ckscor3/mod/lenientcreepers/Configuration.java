package bl4ckscor3.mod.lenientcreepers;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;

@Config(modid=LenientCreepers.MOD_ID, type=Type.INSTANCE, category="general")
public class Configuration
{
	@Comment({"If this is set to false, items will not be destroyed regardless of what the gamerule mobGriefing is set to",
	"Default: true"})
	public static boolean onlyWithMobGriefingGamerule = true;
}
