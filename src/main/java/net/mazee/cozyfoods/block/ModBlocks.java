package net.mazee.cozyfoods.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.CozyFoodsClient;
import net.mazee.cozyfoods.block.custom.*;
import net.mazee.cozyfoods.item.ModCreativeModeTab;
import net.mazee.cozyfoods.item.ModItems;

import net.mazee.cozyfoods.world.feature.tree.LycheeTreeGrower;
import net.mazee.cozyfoods.world.feature.tree.MangoTreeGrower;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.effect.StatusEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.block.WildRiceBlock;

import java.util.function.Supplier;

public class ModBlocks {

    public static final Block JASMINE = registerBlock("jasmine",
            new FlowerBlock(StatusEffects.GLOWING, 5,
                    FabricBlockSettings.copyOf(Blocks.LILY_OF_THE_VALLEY)));

    public static final Block WILD_TARO = Registry.register(Registries.BLOCK, new Identifier(CozyFoods.MODID, "wild_taro"),
            new FlowerBlock(StatusEffects.GLOWING, 5,
                    FabricBlockSettings.copyOf(Blocks.LILY_OF_THE_VALLEY)));

    public static final Block HONEYDEW_CROP = Registry.register(Registries.BLOCK, new Identifier(CozyFoods.MODID, "honeydew_crop"),
            new SprawlingCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block CASSAVA_CROP = Registry.register(Registries.BLOCK, new Identifier(CozyFoods.MODID, "cassava_crop"),
            new CassavaCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block TARO_CROP = Registry.register(Registries.BLOCK, new Identifier(CozyFoods.MODID, "taro_crop"),
            new TaroCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block SPINNER = registerBlock("spinner",
            new SpinnerBlock(FabricBlockSettings.create()
                    .strength(0.5F, 6.0F)
                    .sounds(BlockSoundGroup.GLASS)));

    public static final Block DECORATIVE_BLENDER = registerBlock("decorative_blender",
            new DecorativeBlenderBlock(FabricBlockSettings.create()
                    .strength(0.5F, 6.0F)
                    .sounds(BlockSoundGroup.GLASS)));

    public static final Block MENU_STANDING = registerBlock("menu_standing",
            new MenuStandBlock(FabricBlockSettings.create()
                    .strength(0.2F, 6.0F)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block MENU_WIDE = registerBlock("menu_wide",
            new WideBoardBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.2F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block CASH_REGISTER = registerBlock("cash_register",
            new CashRegisterBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.2F, 6.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_LOG = registerBlock("mango_log",
            new ModFlammableRotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);
    public static final Block LYCHEE_LOG = registerBlock("lychee_log",
            new ModFlammableRotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            new ModFlammableRotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block STRIPPED_LYCHEE_LOG = registerBlock("stripped_lychee_log",
            new ModFlammableRotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_SAPLING = registerBlock("mango_sapling",
            new SaplingBlock(new MangoTreeGrower(),
                    FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_SAPLING = registerBlock("lychee_sapling",
            new SaplingBlock(new LycheeTreeGrower(),
                    FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_LEAVES = registerBlock("mango_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
                {
                    @Override
                    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                        return true;
                    }

                    @Override
                    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                        return 30;
                    }

                    @Override
                    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                        return 60;
                    }
                }, ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_LEAVES = registerBlock("lychee_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 60;
                }
            }, ModCreativeModeTab.CozyFoodsTab);

    public static final Block FLOWERING_LYCHEE_LEAVES = registerBlock("flowering_lychee_leaves",
            new LycheeFruitingLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 60;
                }
            }, ModCreativeModeTab.CozyFoodsTab);

    public static final Block FLOWERING_MANGO_LEAVES = registerBlock("flowering_mango_leaves",
            new MangoFruitingLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 60;
                }
            }, ModCreativeModeTab.CozyFoodsTab);



    public static final Block LYCHEE_PLANKS = registerBlock("lychee_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_SLAB = registerBlock("lychee_slab",
            new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F, 3.0F).sound(SoundType.WOOD))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_STAIRS = registerBlock("lychee_stairs",
            new StairBlock(LYCHEE_PLANKS.get().defaultBlockState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_PRESSURE_PLATE = registerBlock("lychee_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_BUTTON = registerBlock("lychee_button",
            new WoodButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_FENCE = registerBlock("lychee_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_FENCE_GATE = registerBlock("lychee_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_DOOR = registerBlock("lychee_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_TRAPDOOR = registerBlock("lychee_trapdoor",
            new TrapDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_COUNTER = registerBlock("lychee_counter",
            new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_CHAIR = registerBlock("lychee_chair",
            new ChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_TABLE = registerBlock("lychee_table",
            new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.STONE)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_TABLE_FANCY = registerBlock("lychee_table_fancy",
            new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.STONE)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block LYCHEE_CABINET = registerBlock("lychee_cabinet",
            new CabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_PLANKS = registerBlock("mango_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops())
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction){
                    return 20;
                }
            }, ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_SLAB = registerBlock("mango_slab",
            new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F, 3.0F).sound(SoundType.WOOD))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_STAIRS = registerBlock("mango_stairs",
            new StairBlock(MANGO_PLANKS.get().defaultBlockState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS))
            , ModCreativeModeTab.CozyFoodsTab);


    public static final Block MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_BUTTON = registerBlock("mango_button",
            new WoodButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_FENCE = registerBlock("mango_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_DOOR = registerBlock("mango_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            new TrapDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)), ModCreativeModeTab.CozyFoodsTab);


    public static final Block MANGO_COUNTER = registerBlock("mango_counter",
            new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_CHAIR = registerBlock("mango_chair",
            new ChairBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_TABLE = registerBlock("mango_table",
            new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.STONE)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_TABLE_FANCY = registerBlock("mango_table_fancy",
            new TableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final Block MANGO_CABINET = registerBlock("mango_cabinet",
            new CabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    /*
    public static final Block MANGO_SHELF = registerBlock("mango_shelf",
            new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

     */

    public static final Block DISH_RACK = registerBlock("dish_rack",
            new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.3F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);


    public static final Block LYCHEE_HANGING = BLOCKS.register("lychee_hanging",
            new HangingFruitBlock(FabricBlockSettings.copyOf(Blocks.COCOA)
                    .noOcclusion()));

    public static final Block MANGO_HANGING = BLOCKS.register("mango_hanging",
            new HangingFruitBlock(FabricBlockSettings.copyOf(Blocks.COCOA)
                    .noOcclusion()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CozyFoods.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CozyFoods.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CozyFoods.LOGGER.info("Registering ModBlocks for " + CozyFoods.MODID);
    }
}
