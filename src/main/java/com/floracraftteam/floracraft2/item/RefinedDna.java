package com.floracraftteam.floracraft2.item;

import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import net.minecraft.item.Item;

public class RefinedDna extends ItemFloracraft {
	
	public RefinedDna(){
	this.setUnlocalizedName(FC2Reference.REFINEDDNA_NAME);
	FC2Items.register(this);
	}
}