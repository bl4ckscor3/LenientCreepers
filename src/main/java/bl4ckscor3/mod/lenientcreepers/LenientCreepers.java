package bl4ckscor3.mod.lenientcreepers;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.world.GameRules;
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
		if(event.getExplosion().getSourceMob() != null && event.getExplosion().getSourceMob() instanceof CreeperEntity)
		{
			if(!Configuration.onlyWithMobGriefingGamerule() || !event.getExplosion().getSourceMob().getCommandSenderWorld().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
			{
				List<Entity> affected = event.getAffectedEntities();

				for(int i = 0; i < affected.size(); i++)
				{
					if(affected.get(i) instanceof ItemEntity)
						affected.remove(i);
				}
			}
		}
	}
}
