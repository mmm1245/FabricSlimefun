package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.customregistries.CustomEntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntitySpawnS2CPacket.class)
public class EntityDisguiseMixin {
    @Shadow private EntityType<?> entityTypeId;

    @Inject(at = @At("TAIL"), method = "<init>(ILjava/util/UUID;DDDFFLnet/minecraft/entity/EntityType;ILnet/minecraft/util/math/Vec3d;)V")
    public void init(CallbackInfo info){
        EntityType disguised = CustomEntityRegistry.getInstance().get(entityTypeId);
        if(disguised != null)
            this.entityTypeId = disguised;
    }
}
