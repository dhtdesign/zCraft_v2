package com.dhtdesign.zcraftmod.items.tools;

import java.util.List;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ToolHammer extends Item implements IHasModel
{
	public ToolHammer(String name)
	{
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.zCraftTab);
		
		ModItems.ITEMS.add(this);
		setContainerItem(this);
		setMaxStackSize(1);
		//setMaxDamage (32);
		setNoRepair();
		
		
		
		
		
	}
	
	/*
	@Override
	public boolean hasContainerItem(ItemStack stack)
	{
		return true;
	}
	
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		return itemStack.getItemDamage() < itemStack.getMaxDamage() ? new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage() + 1) : ItemStack.EMPTY;
	}
	*/
	
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this , 0, "inventory");
		
	}
	
	
	
}
