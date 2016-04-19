package com.betadev.jsoncrops.registry;

import java.util.HashMap;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.object.Seed;

import net.minecraft.init.Blocks;

public class SeedRegistry {
	public static HashMap<String, Seed> seeds = new HashMap<String, Seed>();
	private static int lastIndex = 0;

	public static void register() {
		registerSeed(new Seed("Test", Blocks.dirt, "dirt", "dirt:2#8"));
	}

	public static Seed getSeed(int damage) {
		for(Seed seed : seeds.values()) {
			if(seed.damage == damage) {
				return seed;
			}
		}
		return null;
	}

	public static void registerSeed(Seed seed) {
		seed.damage = lastIndex++;
		JSONCrops.log.info("Registered seed " + seed.name + " with index " + seed.damage);
		seeds.put(seed.name, seed);
	}
}