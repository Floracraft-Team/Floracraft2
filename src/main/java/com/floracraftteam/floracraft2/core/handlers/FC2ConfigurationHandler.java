package com.floracraftteam.floracraft2.core.handlers;

import java.io.File;

import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.client.event.ConfigChangedEvent;

import net.minecraftforge.common.config.Configuration;

public class FC2ConfigurationHandler {
	
	public static Configuration config;
    public static boolean testValue = false;

    public static void init(File configFile)
    {
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        testValue = config.getBoolean("spawnBioFlower", Configuration.CATEGORY_GENERAL, true, "Spawn BioFlower in the world");

        if (config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(FC2Reference.MODID))
        {
            loadConfiguration();
        }
    }

}
