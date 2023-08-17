package net.mazee.cozyfoods.loot;

import com.mojang.serialization.Codec;
import net.mazee.cozyfoods.CozyFoods;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.loot.modifier.AddItemModifier;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CozyFoods.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE =
            LOOT_MODIFIER_SERIALIZERS.register("add_loot_table", AddLootTableModifier.CODEC);


    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}