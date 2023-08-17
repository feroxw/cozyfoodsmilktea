package net.mazee.cozyfoods.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.mazee.cozyfoods.CozyFoods;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SpinnerScreen extends AbstractContainerScreen<SpinnerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CozyFoods.MODID,"textures/gui/spinner_gui.png");
    //private FluidTankRenderer renderer;

    public SpinnerScreen(SpinnerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        //assignEnergyInfoArea();
        //assignFluidRenderer();
    }

    //private void assignFluidRenderer() {
        //renderer = new FluidTankRenderer(50000, true, 16, 61);
    //}

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pPoseStack, x, y);
        renderFuelProgressBar(pPoseStack, x, y);
        renderMilkProgressBar(pPoseStack, x, y);
        //energyInfoArea.draw(pPoseStack);

        //renderer.render(pPoseStack, x + 55, y + 15, menu.getFluidStack());
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            blit(pPoseStack, x + 81, y + 32, 176, 0, menu.getScaledProgress(), 12);
        }
    }

    private void renderFuelProgressBar(PoseStack pPoseStack, int x, int y) {
        blit(pPoseStack, x + 138, y + 34, 176, 12, menu.getScaledFuelProgress(), 6);
    }

    private void renderMilkProgressBar(PoseStack pPoseStack, int x, int y) {
        blit(pPoseStack, x + 71, y + 21 + menu.getScaledMilkMissing(), 176, 24 + menu.getScaledMilkMissing(), 7, 36);
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
