package net.mazee.cozyfoods.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class WildWaterCrop extends CropBlock implements SimpleWaterloggedBlock {
    public WildWaterCrop(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        //return pState.is(BlockTags.DIRT);
        //return pPos.getY() == 61;
        return true;
    }
}
