package net.mazee.cozyfoods.block.entity;

import net.mazee.cozyfoods.CozyFoods;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> MOD_ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CozyFoods.MODID);

    public static final RegistryObject<EntityType<ChairEntity>> CHAIR = MOD_ENTITIES.register("chair",
            () -> EntityType.Builder.<ChairEntity>of((type, world) -> new ChairEntity(world), MobCategory.MISC)
                    .sized(0.0F, 0.0F)
                    .setCustomClientFactory((spawnEntity, world) -> new ChairEntity(world))
                    .build("chair"));

    public static void register(IEventBus eventBus) {
        MOD_ENTITIES.register(eventBus);
    }
}
