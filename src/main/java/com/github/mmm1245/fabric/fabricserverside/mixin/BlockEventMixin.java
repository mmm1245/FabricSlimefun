package com.github.mmm1245.fabric.fabricserverside.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.network.packet.s2c.play.BlockEventS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEventS2CPacket.class)
public class BlockEventMixin {
    @Shadow private Block block;

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;II)V")
    public void init(CallbackInfo info){
        //System.out.println("log" + block.getName());
        /*if(block instanceof FurnaceBlock){
            block = Blocks.SMOOTH_SANDSTONE_SLAB;
        }*/
    }
}
