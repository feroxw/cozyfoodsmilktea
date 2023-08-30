package net.mazee.cozyfoods.block.entity.client.armor;

import net.mazee.cozyfoods.item.custom.BunnyEarsItem;
import net.mazee.cozyfoods.item.custom.WolfEarsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WolfEarsRenderer extends GeoArmorRenderer<WolfEarsItem>{
    public WolfEarsRenderer() {
        super(new WolfEarsModel());

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
