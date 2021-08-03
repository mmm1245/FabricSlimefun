package com.github.mmm1245.fabric.fabricserverside.customregistries;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.item.Item;

import java.util.HashMap;

public class CustomBlockRegistry {
    private static CustomBlockRegistry instance = new CustomBlockRegistry();
    HashMap<Block, CustomBlockRegistry.CustomBlockEntry> customItems;
    private CustomBlockRegistry(){
        this.customItems = new HashMap<>();
        CustomBlockRegistry.instance = this;
    }
    public static CustomBlockRegistry getInstance() {
        return instance;
    }
    public void register(CustomBlockRegistry.CustomBlockEntry block){
        customItems.put(block.getGetOriginal(), block);
    }
    public void registerMushrooms(){
        register(new CustomBlockEntry(Blocks.MUSHROOM_STEM, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.MUSHROOM_STEM.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.BROWN_MUSHROOM, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.BROWN_MUSHROOM.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.BROWN_MUSHROOM_BLOCK, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.POTTED_BROWN_MUSHROOM, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.POTTED_BROWN_MUSHROOM.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.POTTED_RED_MUSHROOM, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.POTTED_RED_MUSHROOM.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.RED_MUSHROOM, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.RED_MUSHROOM.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.RED_MUSHROOM_BLOCK, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.RED_MUSHROOM_BLOCK.getDefaultState();
            }
        }));
    }
    public void registerNoteBlocks(){
        register(new CustomBlockEntry(Blocks.NOTE_BLOCK, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.NOTE_BLOCK.getDefaultState();
            }
        }));
    }
    public void registerCactus(){
        register(new CustomBlockEntry(Blocks.CACTUS, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.CACTUS.getDefaultState();
            }
        }));
    }
    public void registerSugarCane(){
        register(new CustomBlockEntry(Blocks.SUGAR_CANE, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.SUGAR_CANE.getDefaultState();
            }
        }));
    }
    public void registerVines(){
        register(new CustomBlockEntry(Blocks.TWISTING_VINES, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.TWISTING_VINES.getDefaultState();
            }
        }));
        register(new CustomBlockEntry(Blocks.WEEPING_VINES, new CustomBlockEntry.CustomBlockStateBuilder() {
            @Override
            public BlockState get() {
                return Blocks.WEEPING_VINES.getDefaultState();
            }
        }));
    }
    public CustomBlockRegistry.CustomBlockEntry get(Block block){
        return customItems.get(block);
    }

    public static class CustomBlockEntry{
        private Block getOriginal;
        private CustomBlockStateBuilder newState;
        public CustomBlockEntry(Block original, CustomBlockStateBuilder newState) {
            this.getOriginal = original;
            this.newState = newState;
        }

        public Block getGetOriginal() {
            return getOriginal;
        }

        public BlockState getNewState() {
            return newState.get();
        }
        public static abstract class CustomBlockStateBuilder{
            public abstract BlockState get();
        }
    }
}
