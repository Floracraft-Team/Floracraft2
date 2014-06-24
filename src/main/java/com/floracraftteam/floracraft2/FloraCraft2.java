package com.floracraftteam.floracraft2;

import net.minecraftforge.common.MinecraftForge;

import com.floracraftteam.floracraft2.block.FC2Blocks;
import com.floracraftteam.floracraft2.core.handlers.FC2CraftingHandler;
import com.floracraftteam.floracraft2.core.helpers.DropsHelper;
import com.floracraftteam.floracraft2.core.helpers.LogHelper;
import com.floracraftteam.floracraft2.core.proxy.CommonProxy;
import com.floracraftteam.floracraft2.core.reference.FC2Reference;
import com.floracraftteam.floracraft2.item.FC2Items;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="FloraCraft2", name="FloraCraft 2", version="1.7.2-1.0")
public class FloraCraft2 {
	
	@Mod.Instance
	public static FloraCraft2 instance;
	
    @SidedProxy(clientSide = FC2Reference.CLIENTPROXYLOCATION, serverSide = FC2Reference.COMMONPROXYLOCATION)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		LogHelper.init();
		FC2Blocks.loadBlocks();
		FC2Items.loadItems();
		FC2CraftingHandler.loadRecipes();
		
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new DropsHelper());
		
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
