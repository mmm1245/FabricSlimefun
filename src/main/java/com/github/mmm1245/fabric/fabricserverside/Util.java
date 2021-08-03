package com.github.mmm1245.fabric.fabricserverside;

import com.github.mmm1245.fabric.fabricserverside.customregistries.CustomBlockRegistry;
import com.github.mmm1245.fabric.fabricserverside.customregistries.CustomItemRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.ScreenHandlerType;

public class Util {
    public static ItemStack disguiseItem(ItemStack is){
        if(is == null)  return null;
        CustomItemRegistry.CustomItemEntry ent = CustomItemRegistry.getInstance().get(is.getTranslationKey());
        if(ent == null) return null;
        ItemStack is2 = ent.getDisguiseItem().getDefaultStack();

        CompoundTag tag = is.getTag();
        tag.remove("id");
        is2.setTag(tag);
        if(!is.hasCustomName()) {
            CompoundTag t = is2.getOrCreateSubTag("display");
            t.putString("Name", "{\"text\":\"" + ent.getName() + "\",\"italic\":false}");
        }

        is2.getTag().putInt("customModelData", ent.getCustomModelData());
        is2.getTag().putString("realItem", ent.getCustomItem().getTranslationKey());
        return is2;
    }
    public static ItemStack undisguiseItem(ItemStack is){
        if(is == null)   return null;
        if(!is.hasTag()) return is;

        if(is.getTag().getString("realItem").isEmpty()) return is;
        CustomItemRegistry.CustomItemEntry ent = CustomItemRegistry.getInstance().get(is.getTag().getString("realItem"));

        if(ent == null)  return is;
        ItemStack is2 = ent.getCustomItem().getDefaultStack();

        CompoundTag tag = is.getTag();
        tag.remove("id");
        is2.setTag(tag);
        is2.getTag().remove("customModelData");
        return is2;
    }
    public static BlockState disguiseBlockstate(BlockState state){
        CustomBlockRegistry.CustomBlockEntry entry = CustomBlockRegistry.getInstance().get(state.getBlock());
        if(entry == null)
            return state;
        return entry.getNewState();
    }
}
