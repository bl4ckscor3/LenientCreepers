package bl4ckscor3.mod.lenientcreepers;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.level.ExplosionEvent;

@Mod(LenientCreepers.MODID)
@EventBusSubscriber
public class NeoEntrypoint {
	public NeoEntrypoint(ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
		LenientCreepers.onExplosionDetonate(event.getExplosion(), event.getAffectedEntities());
	}
}
