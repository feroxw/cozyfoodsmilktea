package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.item.custom.WolfEarsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WolfEarsModel extends AnimatedGeoModel<WolfEarsItem> {
    @Override
    public ResourceLocation getModelResource(WolfEarsItem wolfEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "geo/wolf_ears.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WolfEarsItem wolfEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "textures/models/armor/wolf_ears.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WolfEarsItem wolfEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "animations/armor_animation.json");
    }
}
