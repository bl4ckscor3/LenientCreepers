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

@Mod(LenientCreepers.MOD_ID)
@EventBusSubscriber
public class LenientCreepers
{
	public static final String MOD_ID = "lenientcreepers";

	public LenientCreepers()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onExplosionDetonate(ExplosionEvent.Detonate event)
	{
		if(event.getExplosion().getExplosivePlacedBy() != null && event.getExplosion().getExplosivePlacedBy() instanceof CreeperEntity)
		{
			if(!Configuration.onlyWithMobGriefingGamerule() || (Configuration.onlyWithMobGriefingGamerule() && !event.getExplosion().getExplosivePlacedBy().getEntityWorld().getGameRules().getBoolean(GameRules.MOB_GRIEFING)))
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
