package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.item.custom.BeeEarsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BeeEarsRenderer extends GeoArmorRenderer<BeeEarsItem>{
    public BeeEarsRenderer() {
        super(new BeeEarsModel());

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
