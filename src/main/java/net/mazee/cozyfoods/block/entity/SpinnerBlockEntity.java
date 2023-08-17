package net.mazee.cozyfoods.block.entity;

import net.mazee.cozyfoods.block.custom.SpinnerBlock;
import net.mazee.cozyfoods.item.ModItems;
import net.mazee.cozyfoods.networking.ModMessages;
import net.mazee.cozyfoods.networking.packet.ItemStackSyncS2CPacket;
import net.mazee.cozyfoods.recipe.SpinnerRecipe;
import net.mazee.cozyfoods.screen.SpinnerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SpinnerBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(10){
        @Override
        protected void onContentsChanged(int slot){
            setChanged();
            if(!level.isClientSide()){
                ModMessages.sendToClients(new ItemStackSyncS2CPacket(this, worldPosition));
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0, 1, 2, 3, 4, 5 -> true;
                case 6 -> stack.getItem() == ModItems.SPOON.get();
                //case 8 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 7 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private final FluidTank FLUID_TANK = new FluidTank(50000){
        @Override
        protected void onContentsChanged() {
            setChanged();
        }

        @Override
        public boolean isFluidValid(FluidStack stack) {
            //System.out.println(stack.getRawFluid());
            return true;
        }
    };

    public ItemStack getRenderStack() {
        ItemStack stack;

        if(!itemHandler.getStackInSlot(7).isEmpty()) {
            stack = itemHandler.getStackInSlot(7);
        } else {
            stack = itemHandler.getStackInSlot(8);
        }

        return stack;
    }

    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }

    public void setFluid(FluidStack fluid){
        this.FLUID_TANK.setFluid(fluid);
    }

    public FluidStack getFluidStack(){
        return this.FLUID_TANK.getFluid();
    }

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 150;
    private int fuelProgress = 0;
    private int fuelMaxProgress = 450;
    private int milkRemaining = 0;
    private int milkCapacity = 900;

    public SpinnerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SPINNER.get(), pPos, pBlockState);
        this.data = new ContainerData(){
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> SpinnerBlockEntity.this.progress;
                    case 1 -> SpinnerBlockEntity.this.maxProgress;
                    case 2 -> SpinnerBlockEntity.this.fuelProgress;
                    case 3 -> SpinnerBlockEntity.this.fuelMaxProgress;
                    case 4 -> SpinnerBlockEntity.this.milkRemaining;
                    case 5 -> SpinnerBlockEntity.this.milkCapacity;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> SpinnerBlockEntity.this.progress = value;
                    case 1 -> SpinnerBlockEntity.this.maxProgress = value;
                    case 2 -> SpinnerBlockEntity.this.fuelProgress = value;
                    case 3 -> SpinnerBlockEntity.this.fuelMaxProgress = value;
                    case 4 -> SpinnerBlockEntity.this.milkRemaining = value;
                    case 5 -> SpinnerBlockEntity.this.milkCapacity = value;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };
    }

    public int getMilkRemaining(){
        return this.milkRemaining;
    }

    public void setMilkRemaining(int value){
        this.data.set(4, value);
        //change LEVEL blockstate on the Block
        int currentLevel = this.getBlockState().getValue(SpinnerBlock.LEVEL);
        int newLevel = Math.min(currentLevel + 2, SpinnerBlock.MAX_LEVEL);
        this.level.setBlock(this.worldPosition, this.getBlockState().setValue(SpinnerBlock.LEVEL, newLevel), 3);

        setChanged(this.level, this.worldPosition, this.getBlockState());
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Tea Blender");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SpinnerMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return lazyItemHandler.cast();
        }

        if(cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
            return lazyFluidHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyFluidHandler = LazyOptional.of(() -> FLUID_TANK);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyFluidHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("spinner.progress", this.progress);
        nbt.putInt("spinner.fuelRemaining", this.fuelProgress);
        nbt.putInt("spinner.milkRemaining", this.milkRemaining);
        //nbt.putInt("gem_infusing_station.energy", ENERGY_STORAGE.getEnergyStored());
        //nbt = FLUID_TANK.writeToNBT(nbt);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("spinner.progress");
        fuelProgress = nbt.getInt("spinner.fuelRemaining");
        milkRemaining = nbt.getInt("spinner.milkRemaining");
        //ENERGY_STORAGE.setEnergy(nbt.getInt("gem_infusing_station.energy"));
        //FLUID_TANK.readFromNBT(nbt);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SpinnerBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }
        /*
        if(hasGemInFirstSlot(pEntity)) {
            pEntity.ENERGY_STORAGE.receiveEnergy(64, false);
        }*/

        if(hasRecipe(pEntity)) {
            if(pEntity.fuelProgress <= 0){
                if(pEntity.itemHandler.getStackInSlot(6).getCount() > 0){
                    pEntity.itemHandler.extractItem(6, 1, false);
                    pEntity.fuelProgress = 450;
                }
            }else if(hasEnoughMilk(pEntity)){
                pEntity.progress++;
                pEntity.fuelProgress--;
                pEntity.milkRemaining--;


                int newLevel = (int) Math.ceil((double) SpinnerBlock.MAX_LEVEL * pEntity.milkRemaining / pEntity.milkCapacity);
                level.setBlock(pos, state.setValue(SpinnerBlock.LEVEL, newLevel), 3);
            }

            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }

        //if(hasMilkItemInSourceSlot(pEntity)) {
            //transferItemMilkToFluidTank(pEntity);
        //}


    }

    private static boolean hasEnoughMilk(SpinnerBlockEntity pEntity) {
        return pEntity.milkRemaining > 0;
    }

    private static boolean hasEnoughFluid(SpinnerBlockEntity pEntity) {
        return true;
        //return pEntity.FLUID_TANK.getFluidAmount() > 100;
    }

    private static boolean hasMilkItemInSourceSlot(SpinnerBlockEntity pEntity) {
        return pEntity.itemHandler.getStackInSlot(8).getCount() > 0;
    }

    private static void transferItemMilkToFluidTank(SpinnerBlockEntity pEntity) {
        //System.out.println("transferring");
        pEntity.itemHandler.getStackInSlot(8).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(handler -> {
            int transferAmount = Math.min(pEntity.FLUID_TANK.getSpace(), 100);
            //System.out.println(transferAmount);
            //System.out.println(handler.getTanks());
            FluidStack stack = handler.drain(transferAmount, IFluidHandler.FluidAction.SIMULATE);
            //System.out.println(stack.getAmount());
            if(pEntity.FLUID_TANK.isFluidValid(stack)){
                //System.out.println("fluid can go in");
                stack = handler.drain(transferAmount, IFluidHandler.FluidAction.EXECUTE);
                fillTankWithFluid(pEntity, stack, handler.getContainer());
            }
        });
    }

    private static void fillTankWithFluid(SpinnerBlockEntity pEntity, FluidStack stack, ItemStack container) {
        pEntity.FLUID_TANK.fill(stack, IFluidHandler.FluidAction.EXECUTE);
        //System.out.println("filling");
        //System.out.println(stack.getAmount());
        //System.out.println(pEntity.FLUID_TANK.getFluidAmount());
        pEntity.itemHandler.extractItem(8, 1, false);
        pEntity.itemHandler.insertItem(8, container, false);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(SpinnerBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<SpinnerRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(SpinnerRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(pEntity)) {
            if(!level.isClientSide()){
                level.playSound(null, pEntity.getBlockPos(), SoundEvents.NOTE_BLOCK_XYLOPHONE, SoundSource.BLOCKS, 0.8F, 1.0F);
            }

            //pEntity.FLUID_TANK.drain(recipe.get().getFluid().getAmount(), IFluidHandler.FluidAction.EXECUTE);
            //pEntity.FLUID_TANK.drain(1000, IFluidHandler.FluidAction.EXECUTE);
            pEntity.itemHandler.extractItem(0, 1, false);
            pEntity.itemHandler.extractItem(1, 1, false);
            pEntity.itemHandler.extractItem(2, 1, false);
            pEntity.itemHandler.extractItem(3, 1, false);
            pEntity.itemHandler.extractItem(4, 1, false);
            pEntity.itemHandler.extractItem(5, 1, false);
            pEntity.itemHandler.setStackInSlot(7, new ItemStack(recipe.get().getResultItem().getItem(),
                    pEntity.itemHandler.getStackInSlot(7).getCount() + 1));

            pEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(SpinnerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<SpinnerRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(SpinnerRecipe.Type.INSTANCE, inventory, level);


        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(7).getItem() == stack.getItem() || inventory.getItem(7).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(7).getMaxStackSize() > inventory.getItem(7).getCount();
    }
}
