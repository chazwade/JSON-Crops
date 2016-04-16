package com.betadev.jsoncrops.registry;

import java.util.HashMap;

import com.betadev.jsoncrops.object.Seed;

public class SeedRegistry {
	public static HashMap<String, Seed> seeds = new HashMap<String, Seed>();

	public static void register() {
		seeds.put("Test", new Seed());
	}
}