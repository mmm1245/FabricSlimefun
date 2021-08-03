package com.github.mmm1245.fabric.fabricserverside.customregistries;

import net.minecraft.entity.EntityType;

import java.util.HashMap;

public class CustomEntityRegistry {
    private static CustomEntityRegistry instance = new CustomEntityRegistry();
    HashMap<EntityType, EntityType> customEntity;
    private CustomEntityRegistry(){
        this.customEntity = new HashMap<>();
        CustomEntityRegistry.instance = this;
    }
    public static CustomEntityRegistry getInstance() {
        return instance;
    }
    public void register(CustomEntityEntry entry){
        customEntity.put(entry.getOriginalEntity(), entry.getDisguisedEntity());
    }
    public EntityType get(EntityType original){
        return customEntity.get(original);
    }

    public static class CustomEntityEntry {
        private EntityType originalEntity;
        private EntityType disguisedEntity;
        public CustomEntityEntry(EntityType originalEntity, EntityType disguisedEntity) {
            this.originalEntity = originalEntity;
            this.disguisedEntity = disguisedEntity;
        }

        public EntityType getOriginalEntity() {
            return originalEntity;
        }

        public EntityType getDisguisedEntity() {
            return disguisedEntity;
        }
    }
}
