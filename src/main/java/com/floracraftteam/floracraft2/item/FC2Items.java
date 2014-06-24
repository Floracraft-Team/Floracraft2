package com.floracraftteam.floracraft2.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class FC2Items {
	
	public static Item rawDna;
	public static Item refinedDna;
	
	public static void loadItems(){
		
		rawDna = new RawDna();
		refinedDna = new RefinedDna();
	}
	
	public static void register(ItemFloracraft item){
		GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
		
	}

}
