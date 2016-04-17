package com.betadev.jsoncrops.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class EssenceItemRenderer implements IItemRenderer {
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
		renderItem.renderIcon(5, 5, Blocks.cobblestone.getIcon(0, 0), 6, 1);
		renderItem.renderIcon(2, 6, Blocks.cobblestone.getIcon(0, 0), 12, 5);
		renderItem.renderIcon(5, 11, Blocks.cobblestone.getIcon(0, 0), 6, 1);
		// Render overlay
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
		renderItem.renderIcon(0, 0, item.getIconIndex(), 16, 16);
	}
}