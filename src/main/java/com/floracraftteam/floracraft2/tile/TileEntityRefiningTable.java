package com.floracraftteam.floracraft2.tile;

import com.floracraftteam.floracraft2.core.handlers.PacketHandler;
import com.floracraftteam.floracraft2.core.handlers.network.MessageTileEntityRefiningTable;
import com.floracraftteam.floracraft2.core.reference.FC2Reference;
import com.floracraftteam.floracraft2.core.tile.TileEntityFC2;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRefiningTable extends TileEntityFC2 implements ISidedInventory {
	
	public static final int INVENTORY_SIZE = 4;
    public static final int FUEL_SLOT = 0;
    public static final int INPUT_SLOT = 1;
    public static final int RAWDNA_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;
    public int deviceRefineTime;
    public int fuelBurnTime;
    public int itemRefineTime;
    public ItemStack outputItemStack;

    private ItemStack[] inventory;
    
    public TileEntityRefiningTable(){
    	
    	inventory = new ItemStack[INVENTORY_SIZE];
    }
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        return new int[0];
    }

    public boolean canInsertItem(int var1, ItemStack var2, int var3)
    {
        return isItemValidForSlot(var1, var2);
    }

    public boolean canExtractItem(int var1, ItemStack var2, int var3)
    {
        return false;
    }

    public int getSizeInventory()
    {
        return inventory.length;
    }

    public ItemStack getStackInSlot(int var1)
    {
        return inventory[var1];
    }
    public ItemStack decrStackSize(int var1, int var2)
    {
    	 ItemStack itemStack = getStackInSlot(var1);
         if (itemStack != null)
         {
             if (itemStack.stackSize <= var2)
             {
                 setInventorySlotContents(var1, null);
             }
             else
             {
                 itemStack = itemStack.splitStack(var2);
                 if (itemStack.stackSize == 0)
                 {
                     setInventorySlotContents(var1, null);
                 }
             }
         }

         return itemStack;
    }
    public ItemStack getStackInSlotOnClosing(int var1)
    {
    	ItemStack itemStack = getStackInSlot(var1);
        if (itemStack != null)
        {
            setInventorySlotContents(var1, null);
        }
        return itemStack;
    }
    public void setInventorySlotContents(int var1, ItemStack var2)
    {
    	inventory[var1] = var2;
        if (var2 != null && var2.stackSize > getInventoryStackLimit())
        {
            var2.stackSize = getInventoryStackLimit();
        }
    }
    public String getInventoryName()
    {
        return this.hasCustomName() ? this.getCustomName() : FC2Reference.REFININGTABLE_NAME;
    }

    public boolean hasCustomInventoryName()
    {
        return false;
    }
    public int getInventoryStackLimit()
    {
        return 64;
    }
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return true;
    }
    public void openInventory()
    {

    }
    public void closeInventory()
    {

    }
    public boolean isItemValidForSlot(int var1, ItemStack var2)
    {
        return false;
    }

    public Packet getDescriptionPacket()
    {
        return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityRefiningTable(this, null));
    }
}
