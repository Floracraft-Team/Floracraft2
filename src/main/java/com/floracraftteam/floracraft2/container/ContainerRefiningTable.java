package com.floracraftteam.floracraft2.container;

import com.floracraftteam.floracraft2.tile.TileEntityRefiningTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerRefiningTable extends Container{
	
	private TileEntityRefiningTable tileEntity;
	public ContainerRefiningTable(InventoryPlayer par1InventoryPlayer, IInventory refiningTable)
	{
		tileEntity = (TileEntityRefiningTable) refiningTable;
		this.addSlotToContainer(new SlotRTable(refiningTable, 0, 87, 51));
		this.addSlotToContainer(new Slot(refiningTable, 1, 54, 51));
		this.addSlotToContainer(new SlotOutput(refiningTable, 2, 126, 16));

		int var6;
		int var7;

		for (var6 = 0; var6 < 2; ++var6)
		{
			for (var7 = 0; var7 < 7; ++var7)
			{
				this.addSlotToContainer(new Slot(refiningTable, var7 + var6 * 7 + 1, 38 + var7 * 18, 27 + var6 * 18));
			}
		}

		// Player inventory:

		for (var6 = 0; var6 < 3; ++var6)
		{
			for (var7 = 0; var7 < 9; ++var7)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 124 + var6 * 18));
			}
		}

		for (var6 = 0; var6 < 9; ++var6)
		{
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 66 + 116));
		}
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {

		return tileEntity.isUseableByPlayer(entityPlayer);
	}
	@Override
	public void onContainerClosed(EntityPlayer entityplayer)
	{
		super.onContainerClosed(entityplayer);
}

}
