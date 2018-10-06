package com.dhtdesign.zcraftmod.util;

import com.dhtdesign.zcraftmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZCraftTab extends CreativeTabs 
{

	public ZCraftTab() { super("tabzCraft"); }
	public ItemStack getTabIconItem() {	return new ItemStack(ModItems.ENDER_CRYSTAL);	}

}
