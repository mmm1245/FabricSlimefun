package com.github.mmm1245.fabric.fabricserverside;

import com.github.mmm1245.fabric.fabricserverside.customregistries.CustomBlockRegistry;
import com.github.mmm1245.fabric.fabricserverside.customregistries.CustomEntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricServerSide implements ModInitializer {

    @Override
    public void onInitialize() {
        CustomBlockRegistry.getInstance().register(new CustomBlockRegistry.CustomBlockEntry(Blocks.FURNACE, new CustomBlockRegistry.CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.BRICKS.getDefaultState();
            }
        }));
        CustomBlockRegistry.getInstance().register(new CustomBlockRegistry.CustomBlockEntry(Registry.BLOCK.get(new Identifier("earlygame", "stone_rock_block")), new CustomBlockRegistry.CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.COBBLESTONE.getDefaultState();
            }
        }));
        CustomBlockRegistry.getInstance().registerMushrooms();
        CustomBlockRegistry.getInstance().registerNoteBlocks();
        CustomBlockRegistry.getInstance().registerCactus();
        CustomBlockRegistry.getInstance().registerSugarCane();
        CustomBlockRegistry.getInstance().registerVines();

        CustomEntityRegistry.getInstance().register(new CustomEntityRegistry.CustomEntityEntry(EntityType.ZOMBIE, EntityType.PLAYER));


    }
}
