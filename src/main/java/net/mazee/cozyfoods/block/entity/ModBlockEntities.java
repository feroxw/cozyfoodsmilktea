package net.mazee.cozyfoods.block.entity;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CozyFoods.MODID);

    public static final RegistryObject<BlockEntityType<SpinnerBlockEntity>> SPINNER =
            BLOCK_ENTITIES.register("spinner", () ->
                    BlockEntityType.Builder.of(SpinnerBlockEntity::new,
                            ModBlocks.SPINNER.get()).build(null));

    public static final RegistryObject<BlockEntityType<CabinetBlockEntity>> CABINET =
            BLOCK_ENTITIES.register("cabinet", () ->
                    BlockEntityType.Builder.of(CabinetBlockEntity::new,
                            ModBlocks.LYCHEE_CABINET.get(),
                            ModBlocks.MANGO_CABINET.get())
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
