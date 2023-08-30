package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.item.custom.BunnyEarsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BunnyEarsRenderer extends GeoArmorRenderer<BunnyEarsItem>{
    public BunnyEarsRenderer() {
        super(new BunnyEarsModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
