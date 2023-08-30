package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.item.custom.BeeEarsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BeeEarsModel extends AnimatedGeoModel<BeeEarsItem> {
    @Override
    public ResourceLocation getModelResource(BeeEarsItem beeEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "geo/bee_ears.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BeeEarsItem beeEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "textures/models/armor/bee_ears.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BeeEarsItem beeEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "animations/armor_animation.json");
    }
}
