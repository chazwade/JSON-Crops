package com.betadev.jsoncrops.item;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.registry.BlockRegistry;
import com.betadev.jsoncrops.registry.SeedRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemEssence extends Item {
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
}