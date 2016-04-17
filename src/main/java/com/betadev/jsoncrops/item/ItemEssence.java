package com.betadev.jsoncrops.item;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.registry.SeedRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemEssence extends Item {
	private IIcon icon;

	public ItemEssence() {
		super();
		setUnlocalizedName(ModInfo.MOD_ID + ".essence");
		setCreativeTab(JSONCrops.creativeTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getItemStackDisplayName(ItemStack stack) {
		return String.format(StatCollector.translateToLocal(getUnlocalizedName()), StatCollector.translateToLocal(SeedRegistry.getSeed(stack.getItemDamage()).name));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		return icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass) {
		return icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir) {
		icon = ir.registerIcon(ModInfo.MOD_ID + ":essence_overlay");
	}
}