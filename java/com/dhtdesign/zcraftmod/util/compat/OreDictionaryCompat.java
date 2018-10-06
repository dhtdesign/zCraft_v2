package com.dhtdesign.zcraftmod.util.compat;

import com.dhtdesign.zcraftmod.blocks.BlockOres;
import com.dhtdesign.zcraftmod.init.ModBlocks;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.util.handlers.EnumHandler;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompat 
{
	public static void registerOres()
	{
		//OreDictionary.registerOre("oreAzoproit", (Item) ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AZOPROIT));
		OreDictionary.registerOre("ingotAzoproit", ModItems.INGOT_AZOPROIT);
	}
	
}
