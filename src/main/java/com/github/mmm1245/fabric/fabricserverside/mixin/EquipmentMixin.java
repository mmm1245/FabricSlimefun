package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityEquipmentUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(EntityEquipmentUpdateS2CPacket.class)
public class EquipmentMixin {
    @Shadow
    List<Pair<EquipmentSlot, ItemStack>> equipmentList;
    @Inject(method = "<init>(ILjava/util/List;)V", at = @At("TAIL"))
    public void init(CallbackInfo info){
        for(int i = 0;i < equipmentList.size();i++){
            Pair pair = equipmentList.get(i);
            ItemStack stack = (ItemStack) pair.getSecond();
            stack = Util.disguiseItem(stack);
            if(stack == null)   continue;

            equipmentList.set(i, new Pair<EquipmentSlot, ItemStack>((EquipmentSlot) pair.getFirst(), stack));
        }
    }
}
