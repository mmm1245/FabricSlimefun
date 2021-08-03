package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenHandlerSlotUpdateS2CPacket.class)
public class SlotMixin {
    @Shadow
    ItemStack stack;
    @Inject(method = "<init>(IILnet/minecraft/item/ItemStack;)V",at = @At("TAIL"))
    public void init(CallbackInfo info){
        ItemStack disguised = Util.disguiseItem(stack);
        if(disguised == null)
            return;
        stack = disguised;
    }
}
