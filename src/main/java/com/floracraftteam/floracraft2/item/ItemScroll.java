package com.floracraftteam.floracraft2.item;

import com.floracraftteam.floracraft2.core.reference.FC2Reference;

public class ItemScroll extends ItemFloracraft{
	
	public ItemScroll(){
		this.setUnlocalizedName(FC2Reference.SCROLL_NAME);
		FC2Items.register(this);
	}

}
