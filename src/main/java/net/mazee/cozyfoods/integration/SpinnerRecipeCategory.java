package net.mazee.cozyfoods.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.ModBlocks;
import net.mazee.cozyfoods.recipe.SpinnerRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class SpinnerRecipeCategory implements IRecipeCategory<SpinnerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(CozyFoods.MODID, "spinner");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(CozyFoods.MODID, "textures/gui/spinner_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public SpinnerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SPINNER.get()));
    }

    @Override
    public RecipeType<SpinnerRecipe> getRecipeType() {
        return JEICozyFoodsPlugin.SPINNER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Tea Blender");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SpinnerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 15, 22).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 33, 22).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 51, 22).addIngredients(recipe.getIngredients().get(2));
        if(recipe.getIngredients().size() > 3){
            builder.addSlot(RecipeIngredientRole.INPUT, 15, 40).addIngredients(recipe.getIngredients().get(3));
        }
        if(recipe.getIngredients().size() > 4){
            builder.addSlot(RecipeIngredientRole.INPUT, 33, 40).addIngredients(recipe.getIngredients().get(4));
        }
        if(recipe.getIngredients().size() > 5){
            builder.addSlot(RecipeIngredientRole.INPUT, 51, 40).addIngredients(recipe.getIngredients().get(5));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 117, 30).addItemStack(recipe.getResultItem());
    }
}
