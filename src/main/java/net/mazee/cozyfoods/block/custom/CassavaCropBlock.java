package net.mazee.cozyfoods.block.custom;

import net.mazee.cozyfoods.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class CassavaCropBlock extends CropBlock {
    public CassavaCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CASSAVA.get();
    }
}
