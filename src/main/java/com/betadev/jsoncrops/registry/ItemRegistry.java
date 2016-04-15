package com.betadev.jsoncrops.registry;

import com.betadev.jsoncrops.item.ItemSeed;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {
	public static ItemSeed seed;

	public static void register() {
		seed = new ItemSeed();
		GameRegistry.registerItem(seed, "ItemSeed");
	}
}