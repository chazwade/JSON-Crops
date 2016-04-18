package com.betadev.jsoncrops.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

public class SpecialRenderer implements IItemRenderer {
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	public void renderIcon(int x, int y, IIcon icon, int width, int height) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + height), 0, (double) icon.getInterpolatedU(x), (double) icon.getInterpolatedV(height));
		tessellator.addVertexWithUV((double) (x + width), (double) (y + height), 0, (double) icon.getInterpolatedU(width), (double) icon.getInterpolatedV(height));
		tessellator.addVertexWithUV((double) (x + width), (double) (y + 0), 0, (double) icon.getInterpolatedU(width), (double) icon.getInterpolatedV(y));
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + 0), 0, (double) icon.getInterpolatedU(x), (double) icon.getInterpolatedV(y));
		tessellator.draw();
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		float scale = 1;
		if(type != ItemRenderType.INVENTORY) {
			scale = 0.065f;
			if(type != ItemRenderType.ENTITY) {
				GL11.glTranslatef(0, -0.1f, 0);
			} else {
				GL11.glTranslatef(0.5f, 1, 0);
				GL11.glRotatef(-Minecraft.getMinecraft().thePlayer.rotationYaw, 0, 1, 0);
				GL11.glRotatef(180, 0, 0, 1);
			}
		}
		GL11.glScalef(scale, scale, scale);
	}
}