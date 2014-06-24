package com.floracraftteam.floracraft2.block;


import cpw.mods.fml.common.registry.GameRegistry;

public class FC2Blocks {
	
	public static void loadBlocks(){
		
	}
	public static void register(BlockFloracraft block){
		GameRegistry.registerBlock(block, block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
		
	}

}
