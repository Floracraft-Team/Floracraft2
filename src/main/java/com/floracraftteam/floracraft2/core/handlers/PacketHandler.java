package com.floracraftteam.floracraft2.core.handlers;

import com.floracraftteam.floracraft2.core.handlers.network.MessageTileEntityFC2;
import com.floracraftteam.floracraft2.core.handlers.network.MessageTileEntityRefiningTable;
import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	
	  public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(FC2Reference.MODID.toLowerCase());

	  public static void init()
	    {
		    INSTANCE.registerMessage(MessageTileEntityFC2.class, MessageTileEntityFC2.class, 0, Side.CLIENT);
	        INSTANCE.registerMessage(MessageTileEntityRefiningTable.class, MessageTileEntityRefiningTable.class, 1, Side.CLIENT);
	    }


}
