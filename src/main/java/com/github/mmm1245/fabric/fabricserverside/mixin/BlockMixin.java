package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.Material;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockUpdateS2CPacket.class)
public class BlockMixin {
    @Shadow private BlockState state;

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V")
    public void init(CallbackInfo info){
        //System.out.println("log" + state.getBlock().getName());
        this.state = Util.disguiseBlockstate(state);
    }
}
