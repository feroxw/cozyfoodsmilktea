package net.mazee.cozyfoods.effect;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.effect.custom.GrowthEffect;
import net.mazee.cozyfoods.effect.custom.ShrinkEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CozyFoods.MODID);

    public static final RegistryObject<MobEffect> SHRINK = MOB_EFFECTS.register("shrink",
            () -> new ShrinkEffect(MobEffectCategory.NEUTRAL, 3124687));
    public static final RegistryObject<MobEffect> GROWTH = MOB_EFFECTS.register("growth",
            () -> new GrowthEffect(MobEffectCategory.NEUTRAL, 3124687));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
