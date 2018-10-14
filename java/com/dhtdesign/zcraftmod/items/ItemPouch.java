package com.dhtdesign.zcraftmod.items;

import java.util.List;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.items.tileentity.TileEntityPouch;
import com.dhtdesign.zcraftmod.util.Reference;
import com.dhtdesign.zcraftmod.util.handlers.GuiHandler;
import com.dhtdesign.zcraftmod.util.interfaces.IHasModel;

import org.lwjgl.input.Keyboard;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPouch extends Item implements IHasModel {

	public ItemPouch(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.zCraftTab);

		ModItems.ITEMS.add(this);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack held = player.getHeldItem(hand);

		player.openGui(Main.instance, GuiHandler.GUI_POUCH, world, hand == EnumHand.MAIN_HAND ? 1 : 0, 0, 0);
		player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + "OPEN GUI!"));
		return ActionResult.newResult(EnumActionResult.SUCCESS, held);

	}

	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityPouch();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {

		super.addInformation(stack, world, tooltip, advanced);
		tooltip.add(TextFormatting.DARK_GRAY + "test");

		if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			tooltip.add(TextFormatting.ITALIC + "Press SHIFT for more information");

		} else
			tooltip.add(TextFormatting.ITALIC + "test2");
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
