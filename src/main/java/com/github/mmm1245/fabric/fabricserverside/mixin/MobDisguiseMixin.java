package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.customregistries.CustomEntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.MobSpawnS2CPacket;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpawnS2CPacket.class)
public class MobDisguiseMixin {
    @Shadow private int entityTypeId;

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/entity/LivingEntity;)V")
    public void init(CallbackInfo info){
        EntityType disguised = CustomEntityRegistry.getInstance().get(Registry.ENTITY_TYPE.get(entityTypeId));
        if(disguised != null)
            this.entityTypeId = Registry.ENTITY_TYPE.getRawId(disguised);
    }
}
