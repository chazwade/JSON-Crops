package com.betadev.jsoncrops.render;

import org.lwjgl.opengl.GL11;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.object.Seed;
import com.betadev.jsoncrops.registry.SeedRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;

public class SeedItemRenderer extends SpecialRenderer {
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		super.renderItem(type, item, data);
		Seed seed = SeedRegistry.getSeed(item.getItemDamage());
		// Render resource
		if(seed != null) {
			if(seed.blockTexture != null) {
				Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
				renderIcon(4, 4, seed.blockTexture.getIcon(0, 0), 1, 3);
				renderIcon(2, 7, seed.blockTexture.getIcon(0, 0), 7, 4);
				renderIcon(6, 10, seed.blockTexture.getIcon(0, 0), 2, 3);
				renderIcon(9, 8, seed.blockTexture.getIcon(0, 0), 3, 4);
				renderIcon(10, 4, seed.blockTexture.getIcon(0, 0), 1, 1);
				renderIcon(10, 5, seed.blockTexture.getIcon(0, 0), 3, 4);
			} else if(seed.itemTexture != null) {
				renderIcon(4, 4, seed.itemTexture.getIconFromDamage(0), 1, 3);
				renderIcon(2, 7, seed.itemTexture.getIconFromDamage(0), 7, 4);
				renderIcon(6, 10, seed.itemTexture.getIconFromDamage(0), 2, 3);
				renderIcon(9, 8, seed.itemTexture.getIconFromDamage(0), 3, 4);
				renderIcon(10, 4, seed.itemTexture.getIconFromDamage(0), 1, 1);
				renderIcon(10, 5, seed.itemTexture.getIconFromDamage(0), 3, 4);
			}
		} else {
			JSONCrops.log.info("Failed to get seed for index " + item.getItemDamage());
		}
		// Render overlay
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
		renderIcon(0, 0, item.getIconIndex(), 16, 16);
	}
}