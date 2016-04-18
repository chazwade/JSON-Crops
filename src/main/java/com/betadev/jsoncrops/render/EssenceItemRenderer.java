package com.betadev.jsoncrops.render;

import org.lwjgl.opengl.GL11;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.object.Seed;
import com.betadev.jsoncrops.registry.SeedRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;

public class EssenceItemRenderer extends SpecialRenderer {
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		super.renderItem(type, item, data);
		Seed seed = SeedRegistry.getSeed(item.getItemDamage());
		// Render resource
		if(seed != null) {
			if(seed.blockTexture != null) {
				Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
				renderIcon(5, 5, seed.blockTexture.getIcon(0, 0), 6, 1);
				renderIcon(2, 6, seed.blockTexture.getIcon(0, 0), 12, 5);
				renderIcon(5, 11, seed.blockTexture.getIcon(0, 0), 6, 1);
			} else if(seed.itemTexture != null) {
				renderIcon(5, 5, seed.itemTexture.getIconFromDamage(0), 6, 1);
				renderIcon(2, 6, seed.itemTexture.getIconFromDamage(0), 12, 5);
				renderIcon(5, 11, seed.itemTexture.getIconFromDamage(0), 6, 1);
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