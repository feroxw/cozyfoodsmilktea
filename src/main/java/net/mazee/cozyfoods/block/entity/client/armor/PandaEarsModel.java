package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.item.custom.PandaEarsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PandaEarsModel extends AnimatedGeoModel<PandaEarsItem> {
    @Override
    public ResourceLocation getModelResource(PandaEarsItem pandaEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "geo/panda_ears.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PandaEarsItem pandaEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "textures/models/armor/panda_ears.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PandaEarsItem pandaEarsItem) {
        return new ResourceLocation(CozyFoods.MODID, "animations/armor_animation.json");
    }
}
