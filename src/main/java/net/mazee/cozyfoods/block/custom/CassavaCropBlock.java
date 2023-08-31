package net.mazee.cozyfoods.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mazee.cozyfoods.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class CassavaCropBlock extends CropBlock {
    public CassavaCropBlock(FabricBlockSettings pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemConvertible getBaseSeedId() {
        return ModItems.CASSAVA;
    }
}
