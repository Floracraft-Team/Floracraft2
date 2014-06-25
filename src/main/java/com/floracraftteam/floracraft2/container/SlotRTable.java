package com.floracraftteam.floracraft2.container;

import com.floracraftteam.floracraft2.item.ItemScroll;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotRTable extends Slot {

	public SlotRTable(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	@Override
    public boolean isItemValid(ItemStack itemStack) {

        return itemStack.getItem() instanceof ItemScroll;
    }

}
