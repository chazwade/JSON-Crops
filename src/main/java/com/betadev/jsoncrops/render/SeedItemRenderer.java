package com.betadev.jsoncrops.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

public class SeedItemRenderer implements IItemRenderer {
	private RenderItem renderItem = new RenderItem();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		// TODO: Render item properly
		/*
		Forge's rendering stuff (from example).

		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

		// Render item texture
		IIcon icon = new ItemStack(Items.wheat_seeds).getIconIndex();
		renderItem.renderIcon(0, 0, icon, 16, 16);

		// Render square
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_QUADS);
		tessellator.setColorRGBA(0, 0, 0, 128);
		tessellator.addVertex(0, 0, 0);
		tessellator.addVertex(0, 8, 0);
		tessellator.addVertex(8, 8, 0);
		tessellator.addVertex(0, 0, 0);
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);

		// Render text
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		String text = Integer.toString(item.getItemDamage());
		fontRenderer.drawStringWithShadow(text, 1, 1, 0xFFFFFF);
		*/
	}
}