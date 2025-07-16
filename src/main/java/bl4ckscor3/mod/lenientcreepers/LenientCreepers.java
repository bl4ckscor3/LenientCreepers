package bl4ckscor3.mod.lenientcreepers;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.level.ExplosionEvent;

@Mod(LenientCreepers.MODID)
@EventBusSubscriber
public class LenientCreepers {
	public static final String MODID = "lenientcreepers";

	public LenientCreepers(ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
		if (event.getExplosion().getDirectSourceEntity() instanceof Creeper creeper) {
			if (!Configuration.onlyWithMobGriefingGamerule() || !creeper.getCommandSenderWorld().getServer().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
				event.getAffectedEntities().removeIf(ItemEntity.class::isInstance);
		}
	}
}
