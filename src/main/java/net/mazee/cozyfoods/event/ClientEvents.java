package net.mazee.cozyfoods.event;

import net.mazee.cozyfoods.CozyFoods;
import net.mazee.cozyfoods.block.entity.ModBlockEntities;
import net.mazee.cozyfoods.block.entity.ModEntities;
import net.mazee.cozyfoods.block.entity.client.armor.*;
import net.mazee.cozyfoods.block.entity.renderer.ChairRenderer;
import net.mazee.cozyfoods.block.entity.renderer.SpinnerBlockEntityRenderer;
import net.mazee.cozyfoods.item.custom.*;
import net.mazee.cozyfoods.utils.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = CozyFoods.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {

        }
    }

    @Mod.EventBusSubscriber(modid = CozyFoods.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        /*
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
        }*/

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.SPINNER.get(),
                    SpinnerBlockEntityRenderer::new);
            event.registerEntityRenderer(ModEntities.CHAIR.get(),
                    ChairRenderer::new);
        }

        @SubscribeEvent
        public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
            GeoArmorRenderer.registerArmorRenderer(BunnyEarsItem.class, () -> new BunnyEarsRenderer());
            GeoArmorRenderer.registerArmorRenderer(WolfEarsItem.class, () -> new WolfEarsRenderer());
            GeoArmorRenderer.registerArmorRenderer(BeeEarsItem.class, () -> new BeeEarsRenderer());
            GeoArmorRenderer.registerArmorRenderer(PandaEarsItem.class, () -> new PandaEarsRenderer());
            GeoArmorRenderer.registerArmorRenderer(CatEarsItem.class, () -> new CatEarsRenderer());
        }

    }
}
