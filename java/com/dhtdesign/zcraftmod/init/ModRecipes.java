package com.dhtdesign.zcraftmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init()
	{
		//Smelting
		//GameRegistry.addSmelting(ModItems.ENDER_INGOT, new ItemStack(ModBlocks.BLOCK_ENDER, 1), 1.5F);
		//GameRegistry.addSmelting(ModBlocks.BLOCK_ENDER, new ItemStack(Blocks.DIAMOND_BLOCK, 64), 3.5F);
		GameRegistry.addSmelting(ModItems.DUST_IRON, new ItemStack(Items.IRON_INGOT, 1), 0.8F);
		GameRegistry.addSmelting(ModItems.ENDER_DUST, new ItemStack(ModItems.INGOT_ENDER, 1), 0.8F);
		
		//Potions
		
	}
	
	
		
}
