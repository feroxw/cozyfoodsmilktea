package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.item.custom.CatEarsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CatEarsRenderer extends GeoArmorRenderer<CatEarsItem>{
    public CatEarsRenderer() {
        super(new CatEarsModel());

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
