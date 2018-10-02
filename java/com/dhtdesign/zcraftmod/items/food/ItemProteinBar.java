package com.dhtdesign.zcraftmod.items.food;

import java.util.ArrayList;
import java.util.List;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.util.IHasModel;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemProteinBar extends ItemCustomFood implements IHasModel
{

	public ItemProteinBar(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(name, amount, saturation, isWolfFood);
		//setAlwaysEdible();
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 60*20, 5, false, false));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
    {
		return true;
    }
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this , 0, "inventory");
		
	}


    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par3) {
        if(GuiScreen.isShiftKeyDown()){
            list.add(TextFormatting.DARK_PURPLE+"Gives Speed for 60s");
        }else{
            list.add("Press shift for more info");
        }
    }

}
