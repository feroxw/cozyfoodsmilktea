package net.mazee.cozyfoods.world.feature;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CozyFoods.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> MANGO_TREE =
            CONFIGURED_FEATURES.register("mango_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.MANGO_LOG.get()),
                            new MangoTrunkPlacer(7, 1, 0, true),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.MANGO_LEAVES.get().defaultBlockState(), 3).add(ModBlocks.FLOWERING_MANGO_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                            new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MANGO_SPAWN =
            CONFIGURED_FEATURES.register("mango_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.MANGO_CHECKED.getHolder().get(),
                            0.1F)), ModPlacedFeatures.MANGO_CHECKED.getHolder().get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LYCHEE_TREE =
            CONFIGURED_FEATURES.register("lychee_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.LYCHEE_LOG.get()),
                            new LycheeTrunkPlacer(7, 1, 0, true),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.LYCHEE_LEAVES.get().defaultBlockState(), 3).add(ModBlocks.FLOWERING_LYCHEE_LEAVES.get().defaultBlockState(), 1)),
                            new FancyFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                            new TwoLayersFeatureSize(1, 0, 1))
                            //.decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F)))
                            .build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LYCHEE_SPAWN =
            CONFIGURED_FEATURES.register("lychee_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.LYCHEE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.LYCHEE_CHECKED.getHolder().get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> JASMINE = CONFIGURED_FEATURES.register("jasmine",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(12, 6, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.JASMINE.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> WILD_TARO = CONFIGURED_FEATURES.register("wild_taro",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_TARO.get()))))));





    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
