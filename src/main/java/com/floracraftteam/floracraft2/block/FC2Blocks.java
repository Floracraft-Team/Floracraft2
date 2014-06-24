package com.floracraftteam.floracraft2.block;


import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class FC2Blocks {
	
	public static Block refiningTable;
	
	public static void loadBlocks(){
		
		refiningTable = new RefiningTable();
	}
	public static void register(BlockFloracraft block){
		GameRegistry.registerBlock(block, block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
		
	}

}
