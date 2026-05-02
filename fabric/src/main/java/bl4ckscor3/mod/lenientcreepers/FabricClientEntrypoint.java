package bl4ckscor3.mod.lenientcreepers;

import fuzs.forgeconfigapiport.fabric.api.v5.client.ConfigScreenFactoryRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;

public class FabricClientEntrypoint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ConfigScreenFactoryRegistry.INSTANCE.register(LenientCreepers.MODID, ConfigurationScreen::new);
	}
}
