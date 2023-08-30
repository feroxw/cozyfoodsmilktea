package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.item.custom.PandaEarsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class PandaEarsRenderer extends GeoArmorRenderer<PandaEarsItem>{
    public PandaEarsRenderer() {
        super(new PandaEarsModel());

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
