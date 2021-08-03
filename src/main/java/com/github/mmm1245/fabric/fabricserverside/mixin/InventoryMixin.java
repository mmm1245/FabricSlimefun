package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(InventoryS2CPacket.class)
public class InventoryMixin {
    @Shadow private List<ItemStack> contents;

    @Inject(at = @At("TAIL"),method = "<init>(ILnet/minecraft/util/collection/DefaultedList;)V")
    public void init(CallbackInfo info){
        for(int i = 0;i < contents.size();i++){
            ItemStack is = Util.disguiseItem(contents.get(i));
            if(is == null)  continue;
            contents.set(i, is);
        }
    }
}
