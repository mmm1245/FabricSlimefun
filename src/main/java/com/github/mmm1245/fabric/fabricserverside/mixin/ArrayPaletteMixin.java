package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.IdList;
import net.minecraft.world.chunk.ArrayPalette;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArrayPalette.class)
public class ArrayPaletteMixin<T> {
    @Shadow private int size;

    @Shadow @Final private IdList<T> idList;

    @Shadow @Final private T[] array;

    @Inject(at=@At("HEAD"), cancellable = true,method = "toPacket")
    public void toPacket(PacketByteBuf buf, CallbackInfo info) {
        if(array.length == 0)
            return;
        if(array[0] instanceof BlockState) {
            info.cancel();
            buf.writeVarInt(size);
            for (int i = 0; i < this.size; ++i) {
                buf.writeVarInt(this.idList.getRawId((T) Util.disguiseBlockstate((BlockState) this.array[i])));
            }
        }
    }
}
