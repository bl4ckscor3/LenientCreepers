package bl4ckscor3.mod.lenientcreepers.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import bl4ckscor3.mod.lenientcreepers.LenientCreepers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ServerExplosion;
import net.minecraft.world.phys.AABB;

@Mixin(ServerExplosion.class)
public class ServerExplosionMixin {
	@WrapOperation(method = "hurtEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;)Ljava/util/List;"))
	private List<Entity> filterItemsIfEnabled(ServerLevel level, Entity source, AABB aabb, Operation<List<Entity>> original) {
		List<Entity> affectedEntities = original.call(level, source, aabb);
		LenientCreepers.onExplosionDetonate((ServerExplosion) (Object) this, affectedEntities);
		return affectedEntities;
	}
}
