package com.dhtdesign.zcraftmod.items.tools;

import java.util.List;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ToolAxe extends ItemAxe implements IHasModel
{
	public ToolAxe(String name, ToolMaterial material)
	{
		super(material, 8.0F, -3.0F);
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

	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par3) {
		// TODO Auto-generated method stub
		
	}
}
