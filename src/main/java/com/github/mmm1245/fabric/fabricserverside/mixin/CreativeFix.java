package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeInventoryActionC2SPacket.class)
public class CreativeFix {
    @Shadow private ItemStack stack;

    @Inject(at = @At("TAIL"),method = "<init>(ILnet/minecraft/item/ItemStack;)V")
    public void init(CallbackInfo info){
        ItemStack newItem = Util.undisguiseItem(stack);
        if(newItem == null) return;
        stack = newItem;
    }
}
