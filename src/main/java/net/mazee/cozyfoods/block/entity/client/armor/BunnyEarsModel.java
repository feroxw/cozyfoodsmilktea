package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.item.custom.BunnyEarsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BunnyEarsModel extends AnimatedGeoModel<BunnyEarsItem> {
    @Override
    public ResourceLocation getModelResource(BunnyEarsItem bunnyEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "geo/bunny_ears.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BunnyEarsItem bunnyEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "textures/models/armor/bunny_ears.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BunnyEarsItem bunnyEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "animations/armor_animation.json");
    }
}
