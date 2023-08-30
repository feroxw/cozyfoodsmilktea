package net.mazee.cozyfoods.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mazee.cozyfoods.block.entity.ChairEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ChairRenderer extends EntityRenderer<ChairEntity> {
    public ChairRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ChairEntity chairEntity)
    {
        return null;
    }

    @Override
    protected void renderNameTag(ChairEntity entity, Component component, PoseStack stack, MultiBufferSource source, int light) {}
}