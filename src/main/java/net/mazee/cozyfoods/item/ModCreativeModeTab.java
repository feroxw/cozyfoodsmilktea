package net.mazee.cozyfoods.item;

import net.mazee.cozyfoods.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CozyFoodsTab = new CreativeModeTab("cozyfoodstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SPINNER.get());
        }
    };
}
