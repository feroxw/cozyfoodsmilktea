package net.mazee.cozyfoods.item;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.ModBlocks;
import net.mazee.cozyfoods.effect.ModMobEffects;
import net.mazee.cozyfoods.item.custom.*;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CozyFoods.MODID);

    public static final RegistryObject<Item> SPOON = ITEMS.register("spoon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)));
    /*
    public static final RegistryObject<Item> PLATE = ITEMS.register("plate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)));

     */
    public static final RegistryObject<Item> HONEYDEW_SEEDS = ITEMS.register("honeydew_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HONEYDEW_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> HONEYDEW_SLICE = ITEMS.register("honeydew_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab).food(Foods.MELON_SLICE)));

    public static final RegistryObject<Item> CASSAVA = ITEMS.register("cassava",
            () -> new ItemNameBlockItem(ModBlocks.CASSAVA_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON, 20*5), 1.0F)
                            .build())));

    public static final RegistryObject<Item> TARO = ITEMS.register("taro",
            () -> new ItemNameBlockItem(ModBlocks.TARO_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON, 20*5), 1.0F)
                            .build())));

    public static final RegistryObject<Item> TAPIOCA_PEARLS = ITEMS.register("tapioca_pearls",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static final RegistryObject<Item> LYCHEE = ITEMS.register("lychee",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static final RegistryObject<Item> MATCHA_POWDER = ITEMS.register("matcha_powder",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> LYCHEE_MILK_TEA = ITEMS.register("lychee_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*300), 1.0F)
                            .build())));

    public static final RegistryObject<Item> TARO_MILK_TEA = ITEMS.register("taro_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(ModMobEffects.GROWTH.get(), 1), 1.0F)
                            .build())));

    public static final RegistryObject<Item> MATCHA_MILK_TEA = ITEMS.register("matcha_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 20*180), 1.0F)
                            .build())));

    public static final RegistryObject<Item> JASMINE_MILK_TEA = ITEMS.register("jasmine_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200), 1.0F)
                            .build())));

    public static final RegistryObject<Item> HONEYDEW_MILK_TEA = ITEMS.register("honeydew_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 20*180), 1.0F)
                            .build())));

    public static final RegistryObject<Item> MANGO_MILK_TEA = ITEMS.register("mango_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 20*300), 1.0F)
                            .build())));

    public static final RegistryObject<Item> THAI_MILK_TEA = ITEMS.register("thai_milk_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(ModMobEffects.SHRINK.get(), 1), 1.0F).build())));

    public static final RegistryObject<Item> LYCHEE_BUBBLE_TEA =ITEMS.register("lychee_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*480), 1.0F)
                            .build())));

    public static final RegistryObject<Item> TARO_BUBBLE_TEA =ITEMS.register("taro_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(ModMobEffects.GROWTH.get(), 1, 3), 1.0F)
                            .build())));

    public static final RegistryObject<Item> MATCHA_BUBBLE_TEA =ITEMS.register("matcha_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 20*270), 1.0F)
                            .build())));

    public static final RegistryObject<Item> JASMINE_BUBBLE_TEA =ITEMS.register("jasmine_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 20*120), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*120), 1.0F)
                            .build())));

    public static final RegistryObject<Item> HONEYDEW_BUBBLE_TEA =ITEMS.register("honeydew_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 20*270), 1.0F)
                            .build())));

    public static final RegistryObject<Item> MANGO_BUBBLE_TEA =ITEMS.register("mango_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 20*480), 1.0F)
                            .build())));

    public static final RegistryObject<Item> THAI_BUBBLE_TEA = ITEMS.register("thai_bubble_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(ModMobEffects.SHRINK.get(), 1, 6), 1.0F)
                            .build())));

    public static final RegistryObject<Item> MATCHA_GREEN_TEA = ITEMS.register("matcha_green_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 20*90), 1.0F)
                            .build())));

    public static final RegistryObject<Item> JASMINE_GREEN_TEA = ITEMS.register("jasmine_green_tea",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 20*30), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*30), 1.0F)
                            .build())));

    public static final RegistryObject<Item> CASSAVA_CAKE = ITEMS.register("cassava_cake",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CozyFoodsTab)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 20*300), 1.0F)
                            .build())));

    public static final RegistryObject<Item> CAFE_APRON = ITEMS.register("cafe_apron",
            () -> new CafeArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST, (new Item.Properties()).tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> BUNNY_EARS = ITEMS.register("bunny_ears",
            () -> new BunnyEarsItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, (new Item.Properties()).tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> WOLF_EARS = ITEMS.register("wolf_ears",
            () -> new WolfEarsItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, (new Item.Properties()).tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> BEE_EARS = ITEMS.register("bee_ears",
            () -> new BeeEarsItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, (new Item.Properties()).tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> CAT_EARS = ITEMS.register("cat_ears",
            () -> new CatEarsItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, (new Item.Properties()).tab(ModCreativeModeTab.CozyFoodsTab)));

    public static final RegistryObject<Item> PANDA_EARS = ITEMS.register("panda_ears",
            () -> new PandaEarsItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, (new Item.Properties()).tab(ModCreativeModeTab.CozyFoodsTab)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
