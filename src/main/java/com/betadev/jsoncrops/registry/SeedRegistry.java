package com.betadev.jsoncrops.registry;

import java.util.HashMap;

import com.betadev.jsoncrops.object.Seed;

import net.minecraft.init.Blocks;

public class SeedRegistry {
	public static HashMap<String, Seed> seeds = new HashMap<String, Seed>();

	public static void register() {
		seeds.put("Test", new Seed("Test", Blocks.cobblestone));
	}

	public static Seed getSeed(int damage) {
		for(Seed seed : seeds.values()) {
			if(seed.damage == damage) {
				return seed;
			}
		}
		return null;
	}
}