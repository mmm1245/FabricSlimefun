package com.github.mmm1245.fabric.fabricserverside.customregistries;

import net.minecraft.item.Item;

import java.util.HashMap;

public class CustomItemRegistry {
    private static CustomItemRegistry instance = new CustomItemRegistry();
    HashMap<String, CustomItemEntry> customItems;
    private CustomItemRegistry(){
        this.customItems = new HashMap<>();
        CustomItemRegistry.instance = this;
    }
    public static CustomItemRegistry getInstance() {
        return instance;
    }
    public void register(CustomItemEntry item){
        customItems.put(item.getCustomItem().getTranslationKey(), item);
    }
    public CustomItemEntry get(String translationKey){
        return customItems.get(translationKey);
    }

    public static class CustomItemEntry{
        private Item customItem;
        private Item disguiseItem;
        private int customModelData;
        private String name;
        public CustomItemEntry(Item customItem, Item disguiseItem, int customModelData, String name) {
            this.customItem = customItem;
            this.customModelData = customModelData;
            this.name = name;
            this.disguiseItem = disguiseItem;
        }
        public Item getCustomItem() {
            return customItem;
        }

        public int getCustomModelData() {
            return customModelData;
        }

        public String getName() {
            return name;
        }

        public Item getDisguiseItem() {
            return disguiseItem;
        }
    }
}
