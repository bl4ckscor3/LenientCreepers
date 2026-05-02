package bl4ckscor3.mod.lenientcreepers;

import java.util.List;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.gamerules.GameRules;

public class LenientCreepers {
	public static final String MODID = "lenientcreepers";

	public static void onExplosionDetonate(Explosion explosion, List<Entity> affectedEntities) {
		if (explosion.getDirectSourceEntity() instanceof Creeper creeper && creeper.level() instanceof ServerLevel level) {
			if (!Configuration.onlyWithMobGriefingGamerule() || !level.getGameRules().get(GameRules.MOB_GRIEFING))
				affectedEntities.removeIf(ItemEntity.class::isInstance);
		}
	}
}
