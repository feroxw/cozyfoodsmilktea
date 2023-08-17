package net.mazee.cozyfoods.item.custom;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class DrinkItem extends Item {
    public DrinkItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        FoodProperties foodProps = pStack.getItem().getFoodProperties();
        if (foodProps == null) {
            return;
        }
        List<Pair<MobEffectInstance, Float>> effectList = foodProps.getEffects();
        List<Pair<Attribute, AttributeModifier>> attributeList = Lists.newArrayList();

        for (Pair<MobEffectInstance, Float> effectPair : effectList) {
            MobEffectInstance instance = effectPair.getFirst();
            //System.out.println(instance.getDescriptionId());
            MutableComponent iformattabletextcomponent = Component.translatable(instance.getDescriptionId());
            MobEffect effect = instance.getEffect();
            Map<Attribute, AttributeModifier> attributeMap = effect.getAttributeModifiers();
            if (!attributeMap.isEmpty()) {
                for (Map.Entry<Attribute, AttributeModifier> entry : attributeMap.entrySet()) {
                    AttributeModifier rawModifier = entry.getValue();
                    AttributeModifier modifier = new AttributeModifier(rawModifier.getName(), effect.getAttributeModifierValue(instance.getAmplifier(), rawModifier), rawModifier.getOperation());
                    attributeList.add(new Pair<>(entry.getKey(), modifier));
                }
            }

            if (instance.getAmplifier() > 0) {
                iformattabletextcomponent = Component.translatable("potion.withAmplifier", iformattabletextcomponent, Component.translatable("effect.potency.cozyfoods." + instance.getAmplifier()));
            }

            if (instance.getDuration() > 20) {
                iformattabletextcomponent = Component.translatable("potion.withDuration", iformattabletextcomponent, MobEffectUtil.formatDuration(instance, 1.0F));
            }

            pTooltip.add(iformattabletextcomponent.withStyle(effect.getCategory().getTooltipFormatting()));

        }

        if (!attributeList.isEmpty()) {
            pTooltip.add(CommonComponents.EMPTY);
            pTooltip.add((Component.translatable("potion.whenDrank")).withStyle(ChatFormatting.DARK_PURPLE));

            for (Pair<Attribute, AttributeModifier> pair : attributeList) {
                AttributeModifier modifier = pair.getSecond();
                double amount = modifier.getAmount();
                double formattedAmount;
                if (modifier.getOperation() != AttributeModifier.Operation.MULTIPLY_BASE && modifier.getOperation() != AttributeModifier.Operation.MULTIPLY_TOTAL) {
                    formattedAmount = modifier.getAmount();
                } else {
                    formattedAmount = modifier.getAmount() * 100.0D;
                }

                if (amount > 0.0D) {
                    pTooltip.add((Component.translatable("attribute.modifier.plus." + modifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(formattedAmount), Component.translatable(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.BLUE));
                } else if (amount < 0.0D) {
                    formattedAmount = formattedAmount * -1.0D;
                    pTooltip.add((Component.translatable("attribute.modifier.take." + modifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(formattedAmount), Component.translatable(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.RED));
                }
            }
        }

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (itemstack.isEdible()) {
            pPlayer.startUsingItem(pUsedHand);
            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }
    }

    //Taken from PotionItem
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        //List<MobEffectInstance> effects = IForgeItem.getFoodProperties(pStack, pEntityLiving).getEffects();

        if (!pLevel.isClientSide) {
            for(MobEffectInstance mobeffectinstance : PotionUtils.getMobEffects(pStack)) {
                //System.out.println("Checking mob effect instance");
                if (mobeffectinstance.getEffect().isInstantenous()) {
                    mobeffectinstance.getEffect().applyInstantenousEffect(player, player, pEntityLiving, mobeffectinstance.getAmplifier(), 1.0D);
                } else {
                    pEntityLiving.addEffect(new MobEffectInstance(mobeffectinstance));
                }
            }
        }

        if (player != null) {
            //player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                //pStack.shrink(1);
                player.eat(pLevel, pStack);
            }
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (pStack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        //pEntityLiving.gameEvent(GameEvent.DRINK);
        return pStack;
    }
}
