package net.mazee.cozyfoods.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mazee.cozyfoods.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.RandomSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;

public class SprawlingCropBlock extends CropBlock {

    public SprawlingCropBlock(FabricBlockSettings pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemConvertible getSeedItems() {
        return ModItems.HONEYDEW_SEEDS;
    }


    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getGrowthAmount(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        world.setBlockState(pos, this.withAge(i), 2);

        BlockPos posDiagNE = pos.north(1).east(1);
        BlockState stateDiagNE = world.getBlockState(posDiagNE);
        BlockState stateDiagNEBelow = world.getBlockState(posDiagNE.down());

        boolean isFarmland = stateDiagNEBelow.getBlock() == (Blocks.FARMLAND);
        boolean isAir = stateDiagNE.isAir();

        System.out.println("Farmland:" + isFarmland);
        System.out.println("Air:" + isAir);

        if(i==j && isFarmland && isAir){
            world.setBlockState(posDiagNE, this.withAge(0));
            //System.out.println("New Honeydew");
        }
    }

    @Override
    protected int getGrowthAmount(World world) {
        return MathHelper.nextInt(world.random, 2, 5);
    }
}
