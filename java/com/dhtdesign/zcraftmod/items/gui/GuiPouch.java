package com.dhtdesign.zcraftmod.items.gui;

import javax.annotation.Nonnull;

import com.dhtdesign.zcraftmod.blocks.container.ContainerEnderChest;
import com.dhtdesign.zcraftmod.blocks.tileentity.TileEntityEnderChest;
import com.dhtdesign.zcraftmod.items.container.ContainerPouch;
import com.dhtdesign.zcraftmod.items.tileentity.TileEntityPouch;
import com.dhtdesign.zcraftmod.util.Reference;
import com.google.common.base.Preconditions;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;

public class GuiPouch extends GuiContainer {

	private static final ResourceLocation GUI_POUCH = new ResourceLocation(Reference.MOD_ID + ":textures/gui/ender_chest.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityPouch te;
	private static final  EnumHand hand = EnumHand.MAIN_HAND;


	public GuiPouch(InventoryPlayer playerInventory, TileEntityPouch pouchInventory, EntityPlayer player) {
		
		
		
		super(new ContainerPouch(playerInventory, pouchInventory, player, hand));
		 
		this.playerInventory = playerInventory;
		this.te = pouchInventory;

		this.xSize = 179;
		this.ySize = 256;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 16777215);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 16777215);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_POUCH);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

}