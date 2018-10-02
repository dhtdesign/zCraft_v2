package com.dhtdesign.zcraftmod.items;

import java.util.List;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item implements IHasModel{

	
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.zCraftTab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this , 0, "inventory");
		
	}



}
