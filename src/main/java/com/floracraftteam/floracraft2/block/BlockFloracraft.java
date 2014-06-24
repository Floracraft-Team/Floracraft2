package com.floracraftteam.floracraft2.block;

import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import net.minecraft.block.Block;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockFloracraft extends Block{

	protected BlockFloracraft(Material material) {
		super(material);

	}
	public BlockFloracraft(){
		super (Material.rock);
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("tile.%s%s", FC2Reference.RESOURCESPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		 this.blockIcon = iconRegister.registerIcon(FC2Reference.RESOURCESPREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

}
