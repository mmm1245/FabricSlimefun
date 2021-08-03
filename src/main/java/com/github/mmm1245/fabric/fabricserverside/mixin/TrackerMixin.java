package com.github.mmm1245.fabric.fabricserverside.mixin;
import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityTrackerUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(EntityTrackerUpdateS2CPacket.class)
public class TrackerMixin {
    @Shadow
    List<DataTracker.Entry<?>> trackedValues;

    @Inject(at = @At("TAIL"),method = "<init>(ILnet/minecraft/entity/data/DataTracker;Z)V")
    public void init(CallbackInfo info){
        for(int i = 0;i < trackedValues.size();i++){
            DataTracker.Entry<?> entry = trackedValues.get(i);
            if(entry.get() instanceof ItemStack){
                DataTracker.Entry<ItemStack> entryIS = (DataTracker.Entry<ItemStack>) trackedValues.get(i);
                ItemStack disguised = Util.disguiseItem((ItemStack) entry.get());
                if(disguised == null)
                    return;
                entryIS.set(disguised);
            }
        }
    }
}
