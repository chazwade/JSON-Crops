package com.betadev.jsoncrops.registry;

import com.betadev.jsoncrops.Util;
import com.betadev.jsoncrops.object.Seed;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeRegistry {
	public static void register() {
		for(Seed seed : SeedRegistry.seeds.values()) {
			if(seed.inputItem != null) {
				GameRegistry.addRecipe(new ShapedOreRecipe(
					new ItemStack(ItemRegistry.seed, 1, seed.damage),
					"IEI", "ESE", "IEI",
					'I', Util.getInputItem(seed.inputItem),
					'E', new ItemStack(ItemRegistry.infusionStone, 1, seed.tier),
					'S', Items.wheat_seeds
				));
			}
			if(seed.outputItem != null) {
				GameRegistry.addRecipe(new ShapedOreRecipe(
					Util.getOutputItem(seed.outputItem),
					"EEE", "EEE", "EEE",
					'E', new ItemStack(ItemRegistry.essence, 1, seed.damage)
				));
			}
		}
		// TODO: Add recipes for InfusionStone tiers
	}
}