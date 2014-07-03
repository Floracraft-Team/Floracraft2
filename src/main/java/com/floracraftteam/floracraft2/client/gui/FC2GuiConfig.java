package com.floracraftteam.floracraft2.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import com.floracraftteam.floracraft2.core.handlers.FC2ConfigurationHandler;
import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import cpw.mods.fml.client.config.GuiConfig;

public class FC2GuiConfig extends GuiConfig{
	public FC2GuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(FC2ConfigurationHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                FC2Reference.MODID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(FC2ConfigurationHandler.config.toString()));
    }

}
