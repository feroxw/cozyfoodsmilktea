package net.mazee.cozyfoods.block.custom;

import net.mazee.cozyfoods.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;

public class SprawlingCropBlock extends CropBlock {

    public SprawlingCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.HONEYDEW_SEEDS.get();
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            int i = this.getAge(pState);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, pLevel, pPos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int)(25.0F / f) + 1) == 0)) {
                    pLevel.setBlock(pPos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }
            }
        }

    }

    @Override
    public void growCrops(Level pLevel, BlockPos pPos, BlockState pState) {
        int i = this.getAge(pState) + this.getBonemealAgeIncrease(pLevel);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        pLevel.setBlock(pPos, this.getStateForAge(i), 2);

        //System.out.println(i);
        BlockPos posDiagNE = pPos.north(1).east(1);
        BlockState stateDiagNE = pLevel.getBlockState(posDiagNE);
        BlockState stateDiagNEBelow = pLevel.getBlockState(posDiagNE.below());

        boolean isFarmland = stateDiagNEBelow.is(Blocks.FARMLAND);
        boolean isAir = stateDiagNE.is(Blocks.AIR);

        //System.out.println("Farmland:" + isFarmland);
        //System.out.println("Air:" + isAir);

        if(i==j && isFarmland && isAir){
            pLevel.setBlockAndUpdate(posDiagNE, this.getStateForAge(0));
            //System.out.println("New Honeydew");
        }
        //pLevel.setBlockAndUpdate(posDiagNE, this.getStateForAge(0));
    }
}
