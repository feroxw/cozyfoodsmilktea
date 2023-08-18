package net.mazee.cozyfoods.block;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.custom.*;
import net.mazee.cozyfoods.item.ModCreativeModeTab;
import net.mazee.cozyfoods.item.ModItems;

import net.mazee.cozyfoods.world.feature.tree.LycheeTreeGrower;
import net.mazee.cozyfoods.world.feature.tree.MangoTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.world.effect.MobEffects;
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
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CozyFoods.MODID);

    public static final RegistryObject<Block> JASMINE = registerBlock("jasmine",
            () -> new FlowerBlock(MobEffects.GLOWING, 5,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> WILD_TARO = BLOCKS.register("wild_taro",
            () -> new FlowerBlock(MobEffects.GLOWING, 5,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    /*
    public static final RegistryObject<Block> WILD_TARO = BLOCKS.register("wild_taro",
            () -> new WildRiceBlock(Block.Properties.copy(Blocks.TALL_GRASS)));

     */

    public static final RegistryObject<Block> HONEYDEW_CROP = BLOCKS.register("honeydew_crop",
            () -> new SprawlingCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> TARO_CROP = BLOCKS.register("taro_crop",
            () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> MANGO_LOG = registerBlock("mango_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);
    public static final RegistryObject<Block> LYCHEE_LOG = registerBlock("lychee_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> STRIPPED_LYCHEE_LOG = registerBlock("stripped_lychee_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            () -> new SaplingBlock(new MangoTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_SAPLING = registerBlock("lychee_sapling",
            () -> new SaplingBlock(new LycheeTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_LEAVES = registerBlock("mango_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))
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

    public static final RegistryObject<Block> LYCHEE_LEAVES = registerBlock("lychee_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))
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

    public static final RegistryObject<Block> FLOWERING_LYCHEE_LEAVES = registerBlock("flowering_lychee_leaves",
            () -> new LycheeFruitingLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))
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

    public static final RegistryObject<Block> FLOWERING_MANGO_LEAVES = registerBlock("flowering_mango_leaves",
            () -> new MangoFruitingLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))
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

    public static final RegistryObject<Block> MANGO_PLANKS = registerBlock("mango_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
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

    public static final RegistryObject<Block> LYCHEE_PLANKS = registerBlock("lychee_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_SLAB = registerBlock("lychee_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F, 3.0F).sound(SoundType.WOOD))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_STAIRS = registerBlock("lychee_stairs",
            () -> new StairBlock(LYCHEE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS))
            , ModCreativeModeTab.CozyFoodsTab);
    /*
    public static final RegistryObject<Block> LYCHEE_SIGN = BLOCKS.register("lychee_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodType.OAK));

    public static final RegistryObject<Block> LYCHEE_WALL_SIGN = BLOCKS.register("lychee_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodType.OAK));
    */
    public static final RegistryObject<Block> LYCHEE_PRESSURE_PLATE = registerBlock("lychee_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_BUTTON = registerBlock("lychee_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_FENCE = registerBlock("lychee_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_FENCE_GATE = registerBlock("lychee_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_DOOR = registerBlock("lychee_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_TRAPDOOR = registerBlock("lychee_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_SLAB = registerBlock("mango_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0F, 3.0F).sound(SoundType.WOOD))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_STAIRS = registerBlock("mango_stairs",
            () -> new StairBlock(MANGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS))
            , ModCreativeModeTab.CozyFoodsTab);

    /*
    public static final RegistryObject<Block> MANGO_SIGN = BLOCKS.register("mango_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodType.OAK));

    public static final RegistryObject<Block> MANGO_WALL_SIGN = BLOCKS.register("mango_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodType.OAK));
    */
    public static final RegistryObject<Block> MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE))
            , ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_BUTTON = registerBlock("mango_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_FENCE = registerBlock("mango_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_DOOR = registerBlock("mango_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)), ModCreativeModeTab.CozyFoodsTab);


    public static final RegistryObject<Block> MENU_STANDING = registerBlock("menu_standing",
            () -> new MenuStandBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.2F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MENU_WIDE = registerBlock("menu_wide",
            () -> new WideBoardBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.2F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> CASH_REGISTER = registerBlock("cash_register",
            () -> new CashRegisterBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.2F, 6.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_COUNTER = registerBlock("lychee_counter",
            () -> new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_TABLE = registerBlock("lychee_table",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_TABLE_FANCY = registerBlock("lychee_table_fancy",
            () -> new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_TABLE = registerBlock("mango_table",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.STONE)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> LYCHEE_CABINET = registerBlock("lychee_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> MANGO_SHELF = registerBlock("mango_shelf",
            () -> new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.6F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> DISH_RACK = registerBlock("dish_rack",
            () -> new HorizontalFacingBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.3F, 6.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> SPINNER = registerBlock("spinner",
            () -> new SpinnerBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5F, 6.0F)
                    .sound(SoundType.GLASS)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);

    public static final RegistryObject<Block> DECORATIVE_BLENDER = registerBlock("decorative_blender",
            () -> new DecorativeBlenderBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5F, 6.0F)
                    .sound(SoundType.GLASS)
                    .noOcclusion()), ModCreativeModeTab.CozyFoodsTab);


    public static final RegistryObject<Block> LYCHEE_HANGING = BLOCKS.register("lychee_hanging",
            () -> new HangingFruitBlock(BlockBehaviour.Properties.copy(Blocks.COCOA)
                    .noOcclusion()));

    public static final RegistryObject<Block> MANGO_HANGING = BLOCKS.register("mango_hanging",
            () -> new HangingFruitBlock(BlockBehaviour.Properties.copy(Blocks.COCOA)
                    .noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
