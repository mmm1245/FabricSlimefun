package com.github.mmm1245.fabric.fabricserverside.mixin;

import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OpenScreenS2CPacket.class)
public class OpenScreenMixin {
    @Shadow private int screenHandlerId;

    @Inject(at = @At("TAIL"), method = "<init>(ILnet/minecraft/screen/ScreenHandlerType;Lnet/minecraft/text/Text;)V")
    public void init(CallbackInfo info){
        if(Registry.SCREEN_HANDLER.get(screenHandlerId) == ScreenHandlerType.FURNACE){
            this.screenHandlerId = Registry.SCREEN_HANDLER.getRawId(ScreenHandlerType.GENERIC_9X4);
        }
    }
}
