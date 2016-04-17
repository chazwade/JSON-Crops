package com.betadev.jsoncrops.object;

public class Seed {
	public String name = "Null";
	public int lightLevelMin = 9;
	public int lightLevelMax = Integer.MAX_VALUE;
	public int damage = 0; // TODO
	public double extraSeedChance = 0;
	public double extraEssenceDropChance = 0;

	public Seed() {
	};

	public Seed(String name) {
		this.name = name;
	}

	public Seed(String name, int lightLevelMin, int lightLevelMax, double extraSeedChance, double extraEssenceDropChance) {
		this.name = name;
		this.lightLevelMin = lightLevelMin;
		this.lightLevelMax = lightLevelMax;
		this.extraSeedChance = extraSeedChance;
		this.extraEssenceDropChance = extraEssenceDropChance;
	}
}