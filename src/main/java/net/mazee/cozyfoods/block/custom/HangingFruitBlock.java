package net.mazee.cozyfoods.block.custom;

import net.mazee.cozyfoods.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import static net.mazee.cozyfoods.block.custom.FruitingLeavesBlock.AGE;

public class HangingFruitBlock extends Block {
    public HangingFruitBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

        //System.out.println("tick fruit");

        BlockPos posAbove = pPos.above(1);
        BlockState stateAbove = pLevel.getBlockState(posAbove);

        if(!(stateAbove.is(ModBlocks.FLOWERING_LYCHEE_LEAVES.get()) || stateAbove.is(ModBlocks.FLOWERING_MANGO_LEAVES.get()))){
            //System.out.println("i'm a lonely hanging fruit");
            dropResources(pState, pLevel, pPos);
            pLevel.removeBlock(pPos, false);
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, blockEntity, stack);

        BlockPos posAbove = pos.above(1);
        BlockState stateAbove = level.getBlockState(posAbove);

        if(stateAbove.is(ModBlocks.FLOWERING_MANGO_LEAVES.get()) || stateAbove.is(ModBlocks.FLOWERING_LYCHEE_LEAVES.get())){
            level.setBlock(posAbove, stateAbove.setValue(AGE, 0), 2);
        }

    }
}
