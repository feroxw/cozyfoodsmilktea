package net.mazee.cozyfoods.world.feature;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.ModBlocks;
import net.mazee.cozyfoods.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CozyFoods.MODID);


    public static final RegistryObject<PlacedFeature> MANGO_CHECKED = PLACED_FEATURES.register("mango_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.MANGO_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MANGO_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> MANGO_PLACED = PLACED_FEATURES.register("mango_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MANGO_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.2f, 1))));

    public static final RegistryObject<PlacedFeature> LYCHEE_CHECKED = PLACED_FEATURES.register("lychee_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.LYCHEE_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.LYCHEE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> LYCHEE_PLACED = PLACED_FEATURES.register("lychee_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LYCHEE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.2f, 1))));


/*
    public static final RegistryObject<PlacedFeature> PATCH_JASMINE = PLACED_FEATURES.register("patch_jasmine",
            () -> new PlacedFeature(ModConfiguredFeatures.PATCH_JASMINE.getHolder().get(), RarityFilter.onAverageOnceEvery(5),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
*/
    public static final RegistryObject<PlacedFeature> JASMINE_PLACED = PLACED_FEATURES.register("jasmine_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.JASMINE.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> WILD_TARO_PLACED = PLACED_FEATURES.register("wild_taro_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WILD_TARO.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
