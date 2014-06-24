package com.floracraftteam.floracraft2.core.helpers;

import com.floracraftteam.floracraft2.item.FC2Items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DropsHelper {
	
	public static double rand;
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event){
        if (event.source.getDamageType().equals("player")) {
            rand = Math.random();
             if (event.entityLiving instanceof EntityAnimal) {
                  if (rand < 0.10d){
                     event.entityLiving.dropItem(FC2Items.rawDna, 1);

                }
          }
    }
    }

}
