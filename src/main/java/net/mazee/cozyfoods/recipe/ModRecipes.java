package net.mazee.cozyfoods.recipe;

import net.mazee.cozyfoods.CozyFoods;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CozyFoods.MODID);

    public static final RegistryObject<RecipeSerializer<SpinnerRecipe>> SPINNER_SERIALIZER =
            SERIALIZERS.register("spinner", () -> SpinnerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

