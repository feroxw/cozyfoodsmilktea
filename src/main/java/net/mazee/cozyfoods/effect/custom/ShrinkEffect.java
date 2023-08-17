package net.mazee.cozyfoods.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

import javax.annotation.Nullable;

public class ShrinkEffect extends MobEffect {
    public ShrinkEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isInstantenous() {
        return false;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {

    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level.isClientSide()){

            //scaleData.setTargetScale(targetScale);

            ScaleData scaleDataHeight = ScaleTypes.HEIGHT.getScaleData(pLivingEntity);
            //System.out.println("Height " + scaleDataHeight.getScale());
            ScaleData scaleDataWidth = ScaleTypes.WIDTH.getScaleData(pLivingEntity);
            //System.out.println("Width " + scaleDataWidth.getScale());
            float targetScaleHeight = pAmplifier > 0 ? 0.1F : Math.max( scaleDataHeight.getScale() - 0.15F, 0.1F);
            if(scaleDataHeight.getScale() > 1.0F){
                targetScaleHeight = 1.0F;
            }

            scaleDataHeight.setTargetScale(targetScaleHeight);
            scaleDataWidth.setTargetScale(targetScaleHeight);

            ScaleData scaleDataReach = ScaleTypes.REACH.getScaleData(pLivingEntity);
            //System.out.println("Reach " + scaleDataReach.getScale());
            float targetScaleReach = 1.0F;

            scaleDataReach.setTargetScale(targetScaleReach);

            //System.out.println("Motion " + scaleDataMotion.getScale());

        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
