package net.mazee.cozyfoods.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.mazee.cozyfoods.block.custom.SpinnerBlock;
import net.mazee.cozyfoods.block.entity.SpinnerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;


public class SpinnerBlockEntityRenderer implements BlockEntityRenderer<SpinnerBlockEntity> {
    public SpinnerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(SpinnerBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();


        switch (pBlockEntity.getBlockState().getValue(SpinnerBlock.FACING)) {
            case NORTH -> {
                pPoseStack.translate(0.5f, 0.36f, 0.14f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(0));
            }
            case EAST -> {
                pPoseStack.translate(0.86f, 0.36f, 0.5f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(90));
            }
            case SOUTH -> {
                pPoseStack.translate(0.5f, 0.36f, 0.86f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(180));
            }
            case WEST -> {
                pPoseStack.translate(0.14f, 0.36f, 0.5f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(270));
            }
        }

        pPoseStack.scale(0.40f, 0.40f, 0.40f);
        //pPoseStack.mulPose(Vector3f.XP.rotationDegrees(0));

        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.GUI, getLightLevel(pBlockEntity.getLevel(),
                        pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
