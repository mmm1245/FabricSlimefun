package com.github.mmm1245.fabric.fabricserverside.mixin;

import com.github.mmm1245.fabric.fabricserverside.Util;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.IdList;
import net.minecraft.util.collection.Int2ObjectBiMap;
import net.minecraft.world.chunk.BiMapPalette;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiMapPalette.class)
public class BiMapPalleteMixin<T> {
    @Shadow @Final private Int2ObjectBiMap<T> map;

    @Shadow @Final private IdList<T> idList;

    @Shadow @Final private int indexBits;

    @Inject(at=@At("HEAD"),cancellable = true, method = "toPacket")
    public void toPacket(PacketByteBuf buf, CallbackInfo info) {
        /*if (map.size() == 0)
            return;
        if (map.get(0) instanceof BlockState) {
            info.cancel();
            int i = map.size();
            buf.writeVarInt(i);

            for (int j = 0; j < i; ++j) {
                buf.writeVarInt(idList.getRawId((T) Util.disguiseBlockstate((BlockState) this.map.get(j))));
            }
        }*/
    }
}
