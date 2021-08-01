package bl4ckscor3.mod.lenientcreepers;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@Mod("lenientcreepers")
@EventBusSubscriber
public class LenientCreepers
{
	public LenientCreepers()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onExplosionDetonate(ExplosionEvent.Detonate event)
	{
		if(event.getExplosion().getSourceMob() instanceof Creeper creeper)
		{
			if(!Configuration.onlyWithMobGriefingGamerule() || !creeper.getCommandSenderWorld().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
				event.getAffectedEntities().removeIf(e -> e instanceof ItemEntity);
		}
	}
}
