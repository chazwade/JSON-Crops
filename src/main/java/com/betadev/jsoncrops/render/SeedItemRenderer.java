package com.betadev.jsoncrops.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class SeedItemRenderer implements IItemRenderer {
	private RenderItem renderItem = RenderItem.getInstance();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		float scale = 1;
		if(type != ItemRenderType.INVENTORY) {
			scale = 0.065f;
			GL11.glTranslatef(0, -0.1f, 0);
		}
		GL11.glScalef(scale, scale, scale);
		// Render resource
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		renderItem.renderIcon(4, 4, Blocks.cobblestone.getIcon(0, 0), 1, 3);
		renderItem.renderIcon(2, 7, Blocks.cobblestone.getIcon(0, 0), 7, 4);
		renderItem.renderIcon(6, 10, Blocks.cobblestone.getIcon(0, 0), 2, 3);
		renderItem.renderIcon(9, 8, Blocks.cobblestone.getIcon(0, 0), 3, 4);
		renderItem.renderIcon(10, 4, Blocks.cobblestone.getIcon(0, 0), 1, 1);
		renderItem.renderIcon(10, 5, Blocks.cobblestone.getIcon(0, 0), 3, 4);
		// Render overlay
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
		renderItem.renderIcon(0, 0, item.getIconIndex(), 16, 16);
	}
}