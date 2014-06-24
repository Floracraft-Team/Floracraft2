package com.floracraftteam.floracraft2.core.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {
	
	private static Logger fc2logger = Logger.getLogger("FloraCraft2");
	
	public static void init(){
		fc2logger.setParent((Logger) FMLLog.getLogger());
		
	}
	public static void log(Level logLevel, String message){
		fc2logger.log(logLevel, message);
	}

}
