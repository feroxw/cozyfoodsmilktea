package net.mazee.cozyfoods.block.custom;

import net.mazee.cozyfoods.block.ModBlocks;
import net.mazee.cozyfoods.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class MangoFruitingLeavesBlock extends FruitingLeavesBlock {

    public MangoFruitingLeavesBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void growCrops(Level pLevel, BlockPos pPos, BlockState pState) {
        int i = this.getAge(pState) + this.getBonemealAgeIncrease(pLevel);
        int j = this.getMaxAge() - 1;
        if (i > j) {
            i = j;
        }

        pLevel.setBlock(pPos, pState.setValue(AGE, i), 2);

        if(i >= j){
            BlockPos posBelow = pPos.below(1);
            BlockState stateBelow = pLevel.getBlockState(posBelow);

            if(stateBelow.is(Blocks.AIR)){
                pLevel.setBlockAndUpdate(posBelow, ModBlocks.MANGO_HANGING.get().defaultBlockState());

                pLevel.setBlock(pPos, pState.setValue(AGE, this.getMaxAge()), 2);
            }
        }
    }


    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (this.decaying(pState)) {
            dropResources(pState, pLevel, pPos);
            pLevel.removeBlock(pPos, false);

            BlockPos posBelow = pPos.below(1);
            BlockState stateBelow = pLevel.getBlockState(posBelow);

            if(stateBelow.is(ModBlocks.LYCHEE_HANGING.get()) || stateBelow.is(ModBlocks.MANGO_HANGING.get())){
                dropResources(stateBelow, pLevel, posBelow);
                pLevel.removeBlock(posBelow, false);
            }
        }else{
            int i = this.getAge(pState) + 1;
            int j = this.getMaxAge() - 1;
            if (i > j) {
                i = j;
            }

            if ( pRandom.nextInt() < 0 ) {
                pLevel.setBlock(pPos, pState.setValue(AGE, i), 2);
            }

            if(i >= j){
                BlockPos posBelow = pPos.below(1);
                BlockState stateBelow = pLevel.getBlockState(posBelow);

                if(stateBelow.is(Blocks.AIR)){
                    pLevel.setBlockAndUpdate(posBelow, ModBlocks.MANGO_HANGING.get().defaultBlockState());

                    pLevel.setBlock(pPos, pState.setValue(AGE, this.getMaxAge()), 2);
                }
            }
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, blockEntity, stack);

        BlockPos posBelow = pos.below(1);
        BlockState stateBelow = level.getBlockState(posBelow);

        if(stateBelow.is(ModBlocks.MANGO_HANGING.get())){

            dropResources(stateBelow, level, posBelow);
            level.removeBlock(posBelow, false);
        }

    }

}