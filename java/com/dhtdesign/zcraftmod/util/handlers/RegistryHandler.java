package com.dhtdesign.zcraftmod.util.handlers;


import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.blocks.animation.RenderEnderChest;
import com.dhtdesign.zcraftmod.blocks.tileentity.TileEntityEnderChest;
import com.dhtdesign.zcraftmod.init.ModBlocks;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.init.ModRecipes;
import com.dhtdesign.zcraftmod.util.compat.OreDictionaryCompat;
import com.dhtdesign.zcraftmod.util.interfaces.IHasModel;
import com.dhtdesign.zcraftmod.world.gen.WorldGenCustomOres;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderChest.class, new RenderEnderChest());
		
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		Main.proxy.registerModel(Item.getItemFromBlock(ModBlocks.ENDER_CHEST), 0);
		
		for (Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		
		for (Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void otherRegisters()
	{
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	
	public static void preInitRegistries()
	{
		RegistryHandler.otherRegisters();
		
	}
	
	public static void initRegistries()
	{
		ModRecipes.init();
		
		OreDictionary.registerOre("hammer",  new ItemStack(ModItems.HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		
		OreDictionaryCompat.registerOres();
	}
	
	public static void postInitRegistries()
	{
		
	}
	
}
