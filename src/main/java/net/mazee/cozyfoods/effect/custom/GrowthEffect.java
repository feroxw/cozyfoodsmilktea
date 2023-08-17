package net.mazee.cozyfoods.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

import javax.annotation.Nullable;

public class GrowthEffect extends MobEffect {
    public GrowthEffect(MobEffectCategory pCategory, int pColor) {
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
            float targetScaleHeight = pAmplifier > 0 ? 4.0F : Math.min( scaleDataHeight.getScale() + 1.0F, 4.0F);
            if(scaleDataHeight.getScale() < 1.0F){
                targetScaleHeight = 1.0F;
            }

            scaleDataHeight.setTargetScale(targetScaleHeight);
            scaleDataWidth.setTargetScale(targetScaleHeight);

            ScaleData scaleDataReach = ScaleTypes.REACH.getScaleData(pLivingEntity);
            //System.out.println("Reach " + scaleDataReach.getScale());
            float targetScaleReach = Math.max( targetScaleHeight * 0.375F, 1.0F);
            if(scaleDataReach.getScale() < 1.0F){
                targetScaleReach = 1.0F;
            }
            //1 - 1, 2 - 1, 3 - 1.2, 4- 1.5
            scaleDataReach.setTargetScale(targetScaleReach);

            ScaleData scaleDataMotion = ScaleTypes.MOTION.getScaleData(pLivingEntity);
            //System.out.println("Motion " + scaleDataMotion.getScale());
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
