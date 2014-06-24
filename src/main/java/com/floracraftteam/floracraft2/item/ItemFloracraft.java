package com.floracraftteam.floracraft2.item;

import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFloracraft extends Item{
	
	    public String getUnwrappedUnlocalizedName(String unlocalizedName)
	    {
	        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	    }

	    @Override
	    public String getUnlocalizedName()
	    {
	        return String.format("item.%s%s", FC2Reference.RESOURCESPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	    }

	    @Override
	    public String getUnlocalizedName(ItemStack itemStack)
	    {
	        return String.format("item.%s%s", FC2Reference.RESOURCESPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	    }



	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister iconRegister)
	    {
	        this.itemIcon = iconRegister.registerIcon(FC2Reference.RESOURCESPREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	    }

}
