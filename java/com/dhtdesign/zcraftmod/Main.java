package com.dhtdesign.zcraftmod;

import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.init.ModRecipes;
import com.dhtdesign.zcraftmod.proxy.CommonProxy;
import com.dhtdesign.zcraftmod.util.Reference;
import com.dhtdesign.zcraftmod.util.ZCraftTab;
import com.dhtdesign.zcraftmod.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs zCraftTab = new ZCraftTab();
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) { RegistryHandler.preInitRegistries(); }
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {	RegistryHandler.initRegistries(); }
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {	RegistryHandler.postInitRegistries(); }
	
}
