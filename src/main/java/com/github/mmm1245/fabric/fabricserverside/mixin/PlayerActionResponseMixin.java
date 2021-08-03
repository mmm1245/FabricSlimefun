package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.block.BlockState;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerActionResponseS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerActionResponseS2CPacket.class)
public class PlayerActionResponseMixin {
    @Shadow private BlockState state;

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/network/packet/c2s/play/PlayerActionC2SPacket$Action;ZLjava/lang/String;)V")
    public void init(CallbackInfo info){
        this.state = Util.disguiseBlockstate(state);
    }
}
