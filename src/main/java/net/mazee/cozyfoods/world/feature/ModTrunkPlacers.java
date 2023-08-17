package net.mazee.cozyfoods.world.feature;

import net.mazee.cozyfoods.CozyFoods;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES =
            DeferredRegister.createOptional(Registry.TRUNK_PLACER_TYPE_REGISTRY, CozyFoods.MODID);

    public static RegistryObject<TrunkPlacerType<LycheeTrunkPlacer>> LYCHEE_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("lychee_trunk_placer",
            () -> new TrunkPlacerType<>(LycheeTrunkPlacer.CODEC));

    public static RegistryObject<TrunkPlacerType<MangoTrunkPlacer>> MANGO_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("mango_trunk_placer",
            () -> new TrunkPlacerType<>(MangoTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }

}
