package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.item.custom.CatEarsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CatEarsModel extends AnimatedGeoModel<CatEarsItem> {
    @Override
    public ResourceLocation getModelResource(CatEarsItem catEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "geo/cat_ears.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CatEarsItem catEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "textures/models/armor/cat_ears.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CatEarsItem catEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "animations/armor_animation.json");
    }
}
