package net.mazee.cozyfoods;

import com.mojang.logging.LogUtils;
import net.mazee.cozyfoods.block.ModBlocks;
import net.mazee.cozyfoods.block.entity.ModBlockEntities;
import net.mazee.cozyfoods.block.entity.ModEntities;
import net.mazee.cozyfoods.effect.ModMobEffects;
import net.mazee.cozyfoods.item.ModItems;
import net.mazee.cozyfoods.loot.ModLootModifiers;
import net.mazee.cozyfoods.networking.ModMessages;
import net.mazee.cozyfoods.recipe.ModRecipes;
import net.mazee.cozyfoods.screen.ModMenuTypes;
import net.mazee.cozyfoods.screen.SpinnerScreen;
import net.mazee.cozyfoods.world.feature.ModConfiguredFeatures;
import net.mazee.cozyfoods.world.feature.ModPlacedFeatures;
import net.mazee.cozyfoods.world.feature.ModTrunkPlacers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CozyFoods.MODID)
public class CozyFoods
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "cozyfoods";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public CozyFoods()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntities.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModTrunkPlacers.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModMobEffects.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");


        event.enqueueWork(() -> {
            ModMessages.register();
            //ModVillagers.registerPOIs();
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            MenuScreens.register(ModMenuTypes.SPINNER_MENU.get(), SpinnerScreen::new);

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_DOOR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_TRAPDOOR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_TRAPDOOR.get(), RenderType.cutout());
        }
    }
}
