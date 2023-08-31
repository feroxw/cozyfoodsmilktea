package net.mazee.cozyfoods.block.custom;

import net.mazee.cozyfoods.item.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TaroCropBlock extends CropBlock {
    public TaroCropBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TARO.get();
    }
}
