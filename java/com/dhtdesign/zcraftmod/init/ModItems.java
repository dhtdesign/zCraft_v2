package com.dhtdesign.zcraftmod.init;

import java.util.ArrayList;
import java.util.List;

import com.dhtdesign.zcraftmod.items.ItemBase;
import com.dhtdesign.zcraftmod.items.ItemPouch;
import com.dhtdesign.zcraftmod.items.armor.ArmorBase;
import com.dhtdesign.zcraftmod.items.food.ItemCustomFood;
import com.dhtdesign.zcraftmod.items.food.ItemProteinBar;
import com.dhtdesign.zcraftmod.items.tools.ToolAxe;
import com.dhtdesign.zcraftmod.items.tools.ToolHammer;
import com.dhtdesign.zcraftmod.items.tools.ToolHoe;
import com.dhtdesign.zcraftmod.items.tools.ToolPickaxe;
import com.dhtdesign.zcraftmod.items.tools.ToolSpade;
import com.dhtdesign.zcraftmod.items.tools.ToolSword;
import com.dhtdesign.zcraftmod.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials (Armor stats {boots, legs, chest, helm})
	public static final ToolMaterial MATERIAL_ENDER = EnumHelper.addToolMaterial("material_ender", 3, 3000, 9.0F, 4.0F, 22);
	public static final ArmorMaterial ARMOR_MATERIAL_ENDER = EnumHelper.addArmorMaterial("armor_material_ender", Reference.MOD_ID + ":ender", 14, new int[] {5, 8, 10, 4}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	
	// Items
	public static final Item INGOT_ENDER = new ItemBase("ender_ingot");
	public static final Item INGOT_AZOPROIT = new ItemBase("ingot_azoproit");
	public static final Item ENDER_NUGGET = new ItemBase("ender_nugget");
	public static final Item ENDER_PEARL_DUST = new ItemBase("ender_pearl_dust");
	public static final Item DUST_IRON = new ItemBase("dust_iron");
	public static final Item ENDER_DUST = new ItemBase("ender_dust");
	public static final Item ENDER_CRYSTAL = new ItemBase("ender_crystal");
	public static final Item ENDER_GEAR = new ItemBase("ender_gear");
	public static final Item POUCH = new ItemPouch("pouch");
	
	//Tools
	public static final ItemSword ENDER_SWORD = new ToolSword("ender_sword", MATERIAL_ENDER);
	public static final ItemSpade ENDER_SHOVEL = new ToolSpade("ender_shovel", MATERIAL_ENDER);
	public static final ItemPickaxe ENDER_PICKAXE = new ToolPickaxe("ender_pickaxe", MATERIAL_ENDER);
	public static final ItemAxe ENDER_AXE = new ToolAxe("ender_axe", MATERIAL_ENDER);
	public static final ItemHoe ENDER_HOE = new ToolHoe("ender_hoe", MATERIAL_ENDER);
	
	public static final Item HAMMER = new ToolHammer("hammer");
	
	//Armor
	public static final Item ENDER_HELMET = new ArmorBase("ender_helmet", ARMOR_MATERIAL_ENDER, 1, EntityEquipmentSlot.HEAD );
	public static final Item ENDER_CHESTPLATE = new ArmorBase("ender_chestplate", ARMOR_MATERIAL_ENDER, 1, EntityEquipmentSlot.CHEST);
	public static final Item ENDER_LEGGINGS = new ArmorBase("ender_leggings", ARMOR_MATERIAL_ENDER, 2, EntityEquipmentSlot.LEGS);
	public static final Item ENDER_BOOTS = new ArmorBase("ender_boots", ARMOR_MATERIAL_ENDER, 1, EntityEquipmentSlot.FEET);
	
	
	// Potions & Food
	public static final Item HASTE_BLEND = new ItemBase("haste_blend");
	public static final Item EXPLORERS_BLEND = new ItemBase("explorers_blend");
	public static final Item HUNTERS_BLEND = new ItemBase("hunters_blend");
	public static final Item JUMP_BLEND = new ItemBase("jump_blend");
	public static final Item PROTEIN_BAR = new ItemProteinBar("protein_bar",12, 1.5F, false);
	public static final Item SUGAR_CUBE = new ItemCustomFood("sugar_cube", 1, 0.2F, false);

}
