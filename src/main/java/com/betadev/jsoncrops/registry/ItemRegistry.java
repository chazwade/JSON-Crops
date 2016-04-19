package com.betadev.jsoncrops.registry;

import com.betadev.jsoncrops.item.ItemEssence;
import com.betadev.jsoncrops.item.ItemInfusionStone;
import com.betadev.jsoncrops.item.ItemSeed;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {
	public static ItemSeed seed;
	public static ItemEssence essence;
	public static ItemInfusionStone infusionStone;

	public static void register() {
		seed = new ItemSeed();
		GameRegistry.registerItem(seed, "ItemSeed");
		essence = new ItemEssence();
		GameRegistry.registerItem(essence, "ItemEssence");
		infusionStone = new ItemInfusionStone();
		GameRegistry.registerItem(infusionStone, "ItemInfusionStone");
	}
}