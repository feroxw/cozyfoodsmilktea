package net.mazee.cozyfoods.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.recipe.SpinnerRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEICozyFoodsPlugin implements IModPlugin {
    public static RecipeType<SpinnerRecipe> SPINNER_TYPE =
            new RecipeType<>(SpinnerRecipeCategory.UID, SpinnerRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CozyFoods.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                SpinnerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<SpinnerRecipe> recipesSpinner = rm.getAllRecipesFor(SpinnerRecipe.Type.INSTANCE);
        registration.addRecipes(SPINNER_TYPE, recipesSpinner);
        //System.out.println(recipesSpinner.size());
    }
}