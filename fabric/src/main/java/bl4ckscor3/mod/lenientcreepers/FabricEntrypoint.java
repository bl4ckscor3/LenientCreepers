package bl4ckscor3.mod.lenientcreepers;

import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class FabricEntrypoint implements ModInitializer {
	@Override
	public void onInitialize() {
		ConfigRegistry.INSTANCE.register(LenientCreepers.MODID, ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}
}
